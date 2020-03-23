package com.edu.ifsc.library;

import java.util.Scanner;

import com.edu.ifsc.library.dao.AlunoDAO;
import com.edu.ifsc.library.dao.BibliotecarioDAO;
import com.edu.ifsc.library.dao.LivroDAO;
import com.edu.ifsc.library.dao.ProfessorDAO;
import com.edu.ifsc.library.dao.RecepcionistaDAO;
import com.edu.ifsc.library.entities.Aluno;
import com.edu.ifsc.library.entities.Bibliotecario;
import com.edu.ifsc.library.entities.Livro;
import com.edu.ifsc.library.entities.Professor;
import com.edu.ifsc.library.entities.Recepcionista;

public class Main {
	static Scanner t = new Scanner(System.in);

	public static void main(String[] args) {
		Scanner livroScan = new Scanner(System.in);
		LivroDAO daoLivros = new LivroDAO();
		AlunoDAO daoAlunos = new AlunoDAO();
		BibliotecarioDAO daoBibliotecarios = new BibliotecarioDAO();
		ProfessorDAO daoProfessores = new ProfessorDAO();
		RecepcionistaDAO daoRecepcionistas = new RecepcionistaDAO();

		daoLivros.addLivros();
		daoAlunos.addAlunos();
		daoBibliotecarios.addBibliotecarios();
		daoProfessores.addProfessores();
		daoRecepcionistas.addRecepcionistas();

		while (true) {
			menu();
			int escolha = t.nextInt();

			switch (escolha) {

			case 1:
				for (Livro livro : LivroDAO.livrosBiblioteca) {
					System.out.println(livro);
				}
				break;

			case 2:
				System.out.println("\nDigite o nome do livro: ");
				String nome = t.next();
				System.out.println("\nDigite o autor do livro ");
				String autor = t.next();
				System.out.println("\nDigite o ano do livro: ");
				int ano = t.nextInt();
				System.out.println("\nDigite a quantidade de exemplares: ");
				int quantidade = t.nextInt();
				LivroDAO.livrosBiblioteca.add(new Livro(nome, autor, ano, quantidade));
				break;

			case 3:
				System.out.println("Digite o nome do Aluno: ");
				String nomeAluno = t.next();
				System.out.println("Digite o código do Aluno: ");
				int codigoAluno = t.nextInt();
				System.out.println("Digite o curso do Aluno: ");
				String curso = t.next();
				AlunoDAO.alunosList.add(new Aluno(nomeAluno, codigoAluno, curso));
				break;

			case 4:
				System.out.println("[1] - Bibliotecario");
				System.out.println("[2] - Professor");
				System.out.println("[3] - Recepcionista");
				int escolhaFuncionario = t.nextInt();

				System.out.println("Digite o nome do Funcionario: ");
				String nomeFuncionario = t.next();
				System.out.println("Digite o código do Funcionario: ");
				int codigoFuncionario = t.nextInt();

				switch (escolhaFuncionario) {
				case 1:
					Servico servicoEmprestimo = new CadastraEmprestimos();
					BibliotecarioDAO.bibliotecariosList
							.add(new Bibliotecario(nomeFuncionario, codigoFuncionario, servicoEmprestimo));
					System.out.println("Cadastro de bibliotecario(a) feito com sucesso!");
					break;
				case 2:
					Servico ministrarAula = new MinistrarAula();
					ProfessorDAO.professoresList.add(new Professor(nomeFuncionario, codigoFuncionario, ministrarAula));
					System.out.println("Cadastro de professor(a) feito com sucesso!");
					break;
				case 3:
					Servico servicoDevolucao = new DevolveEmprestimos();
					RecepcionistaDAO.recepcionistasList
							.add(new Recepcionista(nomeFuncionario, codigoFuncionario, servicoDevolucao));
					System.out.println("Cadastro de recepcionista feito com sucesso!");
					break;
				default:
					break;
				}

				break;

			case 5:
				System.out.println("\n[1] - Funcionario");
				System.out.println("[2] - Aluno");

				int pessoaEmpresta = t.nextInt();

				if (pessoaEmpresta == 1 || pessoaEmpresta == 2) {
					System.out.println("\nDigite o nome da pessoa que vai emprestar: ");
					String pessoaNome = t.next();

					System.out.println("\nDigite o nome do bibliotecário: ");
					String funcionarioNome = t.next();

					System.out.println("\nDigite o nome do livro: ");
					String livroNome = livroScan.nextLine();

					System.out.println("\nDigite o número de dias de emprestimo: ");
					int dias = t.nextInt();
					boolean isBibliotecario = false;

					for (Bibliotecario bibliotecario : BibliotecarioDAO.bibliotecariosList) {
						if (bibliotecario.getNome().equalsIgnoreCase(funcionarioNome)) {
							isBibliotecario = true;
							System.out.println(BibliotecarioDAO.getBibliotecario(funcionarioNome));
							bibliotecario.executaFuncao();
							bibliotecario.executaEmprestimo(pessoaNome, bibliotecario, livroNome, dias, pessoaEmpresta);
						}
					}
					if (!isBibliotecario) {
						System.out.println(BibliotecarioDAO.getBibliotecario(funcionarioNome));
					}

				} else {
					System.out.println("Opcao inválida!");
					break;
				}
				break;

			case 6:

				System.out.println("\nDigite o nome da pessoa que irá devolver um livro: ");
				String pessoaDevolve = t.next();

				System.out.println("\nDigite o nome do profissional que está registrando a devolucao: ");
				String funcionarioDevolve = t.next();

				System.out.println("\nDigite o nome do livro que irá devolver: ");
				String livroDevolve = livroScan.nextLine();

				System.out.println("\nDigite quantos dias a pessoa ficou com o livro: ");
				int diasDevolucao = t.nextInt();
				boolean isAl = false;
				boolean isBiblio = false;

				System.out.println(LivroDAO.getLivro(livroDevolve));
				System.out.println(AlunoDAO.getAluno(pessoaDevolve));
				Aluno alunoDev = null;
				Recepcionista recepDev = null;
				Bibliotecario bibDev = null;

				for (Aluno aluno : AlunoDAO.alunosList) {
					for (Recepcionista recepcionista : RecepcionistaDAO.recepcionistasList) {
						for (Bibliotecario bibliotecario : BibliotecarioDAO.bibliotecariosList) {
							if (aluno.getNome().equalsIgnoreCase(pessoaDevolve)) {
								if (recepcionista.getNome().equalsIgnoreCase(funcionarioDevolve)) {
									isAl = true;
									recepDev = recepcionista;
									alunoDev = aluno;
								}
							} else if (bibliotecario.getNome().equalsIgnoreCase(pessoaDevolve)) {
								if (recepcionista.getNome().equalsIgnoreCase(funcionarioDevolve)) {
									isBiblio = true;
									recepDev = recepcionista;
									bibDev = bibliotecario;
								}
							}
						}
					}
				}
				if (isAl) {
					for (int i = 0; i < alunoDev.getEmprestimosRealizados().size(); i++) {
						if (alunoDev.getEmprestimosRealizados().get(i).getLivro().getNomeLivro()
								.equalsIgnoreCase(livroDevolve)) {
							recepDev.executaFuncao();
							recepDev.executaDevolucao(alunoDev, alunoDev.getEmprestimosRealizados().get(i),
									diasDevolucao);
						}
					}
				} else if (isBiblio) {
					for (int i = 0; i < bibDev.getEmprestimosRealizados().size(); i++) {
						if (bibDev.getEmprestimosRealizados().get(i).getLivro().getNomeLivro()
								.equalsIgnoreCase(livroDevolve)) {
							recepDev.executaFuncao();
							recepDev.executaDevolucao(bibDev, bibDev.getEmprestimosRealizados().get(i), diasDevolucao);
						}
					}
				} else if (recepDev == null) {
					System.out.println("Funcionario nao cadastrado ou não permitido para o serviço");
				}
				break;

			case 7:
				System.out.println("\nDigite o nome da pessoa para ver seus empréstimos: ");
				String pessoaPesquisa = t.next();
				System.out.println("\n[1] - Funcionário");
				System.out.println("[2] - Aluno");
				int classe = t.nextInt();

				switch (classe) {

				case 1:
					System.out.println(BibliotecarioDAO.getBibliotecario(pessoaPesquisa));

					for (Bibliotecario bibliotecario : BibliotecarioDAO.bibliotecariosList) {
						if (bibliotecario.getNome().equalsIgnoreCase(pessoaPesquisa)) {
							System.out.println(bibliotecario.getEmprestimosRealizados());
						}
					}
					break;

				case 2:
					System.out.println(AlunoDAO.getAluno(pessoaPesquisa));

					for (Aluno aluno : AlunoDAO.alunosList) {
						if (aluno.getNome().equalsIgnoreCase(pessoaPesquisa)) {
							System.out.println(aluno.getEmprestimosRealizados());
						}
					}
					break;

				default:
					break;
				}

				break;

			case 8:
				System.out.println("\nInsira o nome da pessoa: ");
				String namePessoa = t.next();
				System.out.println("\n[1] - XEROX");
				System.out.println("[2] - IMPRESSÃO");
				int choice = t.nextInt();
				Aluno alunoPresente = null;
				Bibliotecario bibPresente = null;
				Professor profPresente = null;
				Recepcionista recepPresente = null;

				boolean isAluno = false;
				boolean isBib = false;
				boolean isRecep = false;
				boolean isProf = false;

				System.out.println("\nInsira a quantidade de páginas: ");
				int paginas = t.nextInt();

				switch (choice) {

				case 1:
					for (Aluno aluno : AlunoDAO.alunosList) {
						for (Bibliotecario bibliotecario : BibliotecarioDAO.bibliotecariosList) {
							for (Professor professor : ProfessorDAO.professoresList) {
								for (Recepcionista recepcionista : RecepcionistaDAO.recepcionistasList) {
									if (aluno.getNome().equalsIgnoreCase(namePessoa)) {
										isAluno = true;
										alunoPresente = aluno;
									} else if (bibliotecario.getNome().equalsIgnoreCase(namePessoa)) {
										isBib = true;
										bibPresente = bibliotecario;
									} else if (professor.getNome().equalsIgnoreCase(namePessoa)) {
										isProf = true;
										profPresente = professor;
									} else if (recepcionista.getNome().equalsIgnoreCase(namePessoa)) {
										isRecep = true;
										recepPresente = recepcionista;
									}
								}
							}
						}
					}
					if (isAluno) {
						alunoPresente.setQuantidadeFolha(paginas);
						System.out.println(
								"\nEsta pessoa é nosso aluno(a), favor cobrar: R$ " + alunoPresente.valorXeroxTotal());
					}
					if (isBib) {
						bibPresente.setQuantidadeFolha(paginas);
						System.out.println("\nEsta pessoa é nosso bibliotecario(a), favor cobrar: R$ "
								+ bibPresente.valorXeroxTotal());
					}
					if (isProf) {
						profPresente.setQuantidadeFolha(paginas);
						System.out.println("\nEsta pessoa é nosso professor(a), favor cobrar: R$ "
								+ profPresente.valorXeroxTotal());
					}
					if (isRecep) {
						recepPresente.setQuantidadeFolha(paginas);
						System.out.println("\nEsta pessoa é nosso(a) recepcionista, favor cobrar: R$ "
								+ recepPresente.valorXeroxTotal());
					}

					break;

				case 2:
					for (Aluno aluno : AlunoDAO.alunosList) {
						for (Bibliotecario bibliotecario : BibliotecarioDAO.bibliotecariosList) {
							for (Professor professor : ProfessorDAO.professoresList) {
								for (Recepcionista recepcionista : RecepcionistaDAO.recepcionistasList) {
									if (aluno.getNome().equalsIgnoreCase(namePessoa)) {
										isAluno = true;
										alunoPresente = aluno;
									} else if (bibliotecario.getNome().equalsIgnoreCase(namePessoa)) {
										isBib = true;
										bibPresente = bibliotecario;
									} else if (professor.getNome().equalsIgnoreCase(namePessoa)) {
										isProf = true;
										profPresente = professor;
									} else if (recepcionista.getNome().equalsIgnoreCase(namePessoa)) {
										isRecep = true;
										recepPresente = recepcionista;
									}
								}
							}
						}
					}
					if (isAluno) {
						alunoPresente.setQuantidadeFolha(paginas);
						System.out.println("\nEsta pessoa é nosso aluno(a), favor cobrar: R$ "
								+ alunoPresente.valorImpressaoTotal());
					}
					if (isBib) {
						bibPresente.setQuantidadeFolha(paginas);
						System.out.println("\nEsta pessoa é nosso bibliotecario(a), favor cobrar: R$ "
								+ bibPresente.valorImpressaoTotal());
					}
					if (isProf) {
						profPresente.setQuantidadeFolha(paginas);
						System.out.println("\nEsta pessoa é nosso professor(a), favor cobrar: R$ "
								+ profPresente.valorImpressaoTotal());
					}
					if (isRecep) {
						recepPresente.setQuantidadeFolha(paginas);
						System.out.println("\nEsta pessoa é nosso(a) recepcionista, favor cobrar: R$ "
								+ recepPresente.valorImpressaoTotal());
					}

					break;

				default:
					break;
				}
			case 9:
				System.out.println("Digite o nome de um funcionario para ver detalhes: ");
				String nomeFunc = t.next();
				boolean isBibliotecario = false;
				boolean isProfessor = false;
				boolean isRecepcionista = false;
				Bibliotecario b = null;
				Professor p = null;
				Recepcionista r = null;

				for (Bibliotecario bib : BibliotecarioDAO.bibliotecariosList) {
					for (Recepcionista recep : RecepcionistaDAO.recepcionistasList) {
						for (Professor prof : ProfessorDAO.professoresList) {
							if (bib.getNome().equalsIgnoreCase(nomeFunc)) {
								isBibliotecario = true;
								b = bib;
							} else if (recep.getNome().equalsIgnoreCase(nomeFunc)) {
								isRecepcionista = true;
								r = recep;
							} else if (prof.getNome().equalsIgnoreCase(nomeFunc)) {
								isProfessor = true;
								p = prof;
							}
						}
					}
				}
				if (isBibliotecario) {
					b.executaFuncao();
				}
				if (isRecepcionista) {
					r.executaFuncao();
				}
				if (isProfessor) {
					p.executaFuncao();
				}
				if (!isBibliotecario && !isRecepcionista && !isProfessor) {
					System.out.println("Funcionario nao está cadastrado no sistema!");
				}

				break;

			default:
				break;
			}
		}

	}

	public static void menu() {
		System.out.println("\n[1] - Listar livros da Biblioteca");
		System.out.println("[2] - Adicionar livro");
		System.out.println("[3] - Adicionar aluno");
		System.out.println("[4] - Adicionar funcionario");
		System.out.println("[5] - Emprestar livro");
		System.out.println("[6] - Devolver livro");
		System.out.println("[7] - Pesquisar empréstimos por nome");
		System.out.println("[8] - Serviço de xerox ou impressão");
		System.out.println("[9] - Pesquisa por colaboradores\n");
	}

}
