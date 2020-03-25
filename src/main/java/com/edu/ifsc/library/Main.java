package com.edu.ifsc.library;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.edu.ifsc.library.controller.CadastraEmprestimos;
import com.edu.ifsc.library.controller.DevolveEmprestimos;
import com.edu.ifsc.library.controller.MinistrarAula;
import com.edu.ifsc.library.dao.AlunoDAO;
import com.edu.ifsc.library.dao.BibliotecarioDAO;
import com.edu.ifsc.library.dao.LivroDAO;
import com.edu.ifsc.library.dao.PessoaDAO;
import com.edu.ifsc.library.dao.ProfessorDAO;
import com.edu.ifsc.library.dao.RecepcionistaDAO;
import com.edu.ifsc.library.entities.Aluno;
import com.edu.ifsc.library.entities.AtividadeBiblioteca;
import com.edu.ifsc.library.entities.LivroAusente;
import com.edu.ifsc.library.entities.Bibliotecario;
import com.edu.ifsc.library.entities.Colaborador;
import com.edu.ifsc.library.entities.Dispositivo;
import com.edu.ifsc.library.entities.LivroEstante;
import com.edu.ifsc.library.entities.Livro;
import com.edu.ifsc.library.entities.LivroState;
import com.edu.ifsc.library.entities.Pessoa;
import com.edu.ifsc.library.entities.Professor;
import com.edu.ifsc.library.entities.Recepcionista;
import com.edu.ifsc.library.entities.Servico;

public class Main {
	static Scanner t = new Scanner(System.in);

	public static void main(String[] args) {
		Scanner scanLine = new Scanner(System.in);
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

		AtividadeBiblioteca admin = new AtividadeBiblioteca("Administrativo");
		AtividadeBiblioteca reitoria = new AtividadeBiblioteca("Reitoria");
		AtividadeBiblioteca papelaria = new AtividadeBiblioteca("Papelaria");

		Dispositivo monitor = new Dispositivo("Sistema");
		Dispositivo email = new Dispositivo("Email");
		Dispositivo impressora = new Dispositivo("Impressora");

		papelaria.registraObserver(impressora);
		papelaria.registraObserver(monitor);

		reitoria.registraObserver(email);
		admin.registraObserver(monitor);
		admin.notifyObserver("O sistema bibliotecário foi iniciado");

		while (true) {
			menu();
			int escolha = t.nextInt();

			LivroState estanteState = new LivroEstante();
			LivroState ausenteState = new LivroAusente();

			for (Livro livro : LivroDAO.livrosBiblioteca) {
				if (livro.getQuantidade() == 1) {
					estanteState.onAction(livro);
				} else {
					ausenteState.onAction(livro);
				}
			}

			switch (escolha) {

			case 1:
				System.out.println("[1] - Listar Livros");
				System.out.println("[2] - Listar Alunos");
				int lista = t.nextInt();
				if (lista == 1) {
					for (Livro livro : LivroDAO.livrosBiblioteca) {
						System.out.println(livro);
					}
				} else if (lista == 2) {
					for (Aluno aluno : AlunoDAO.alunosList) {
						System.out.println(aluno + " Estado: " + aluno.getEstado().getState());
					}
				} else {
					break;
				}
				break;

			case 2:
				System.out.println("[1] - Adicionar novo funcionario");
				System.out.println("[2] - Mudar função de um funcionario existente");
				System.out.println("[3] - Pesquisa por nome de funcionario");
				int escolhaFunc = t.nextInt();

				if (escolhaFunc == 1) {
					addFuncionario();
					reitoria.notifyObserver("O site do IFSC teve alterações.");
				} else if (escolhaFunc == 2) {
					mudarFuncaoFuncionario();
				} else if (escolhaFunc == 3) {
					pesquisaFuncionario();
				} else {
					System.out.println("Opção inválida!");
				}
				break;

			case 3:
				System.out.println("\n[1] - Professor");
				System.out.println("[2] - Aluno");

				int pessoaEmpresta = t.nextInt();

				if (pessoaEmpresta == 1 || pessoaEmpresta == 2) {
					System.out.println("\nDigite o nome da pessoa que vai emprestar: ");
					String pessoaNome = scanLine.nextLine();

					System.out.println("\nDigite o nome do bibliotecário: ");
					String funcionarioNome = scanLine.nextLine();

					System.out.println("\nDigite o nome do livro: ");
					String livroNome = scanLine.nextLine();

					System.out.println("\nDigite o número de dias de emprestimo: ");
					int dias = t.nextInt();

					System.out.println(LivroDAO.getLivro(livroNome));
					System.out.println(PessoaDAO.getPessoa(pessoaNome));

					Colaborador colaborador = null;
					boolean encontrou = false;

					for (Bibliotecario bibliotecario : BibliotecarioDAO.bibliotecariosList) {
						if (bibliotecario.getNome().equalsIgnoreCase(funcionarioNome)
								&& bibliotecario.getFuncao().toString().equalsIgnoreCase("Cadastra Emprestimos")) {
							colaborador = bibliotecario;
							encontrou = true;
						}
					}
					for (Professor p : ProfessorDAO.professoresList) {
						if (p.getNome().equalsIgnoreCase(funcionarioNome)
								&& p.getFuncao().toString().equalsIgnoreCase("Cadastra Emprestimos")) {
							colaborador = p;
							encontrou = true;
						}
					}
					for (Bibliotecario b : BibliotecarioDAO.bibliotecariosList) {
						if (b.getNome().equalsIgnoreCase(funcionarioNome)
								&& b.getFuncao().toString().equalsIgnoreCase("Cadastra Emprestimos")) {
							colaborador = b;
							encontrou = true;
						}
					}

					if (encontrou) {
						colaborador.executaFuncao();
						colaborador.emprestar(pessoaNome, colaborador, livroNome, dias, pessoaEmpresta);
					}else {
						System.out.println(PessoaDAO.getPessoa(funcionarioNome));
					}

				} else {
					System.out.println("Opcao inválida!");
					break;
				}
				break;

			case 4:

				System.out.println("\nDigite o nome da pessoa que irá devolver um livro: ");
				String pessoaDevolve = scanLine.nextLine();

				System.out.println("\nDigite o nome do profissional que está registrando a devolucao: ");
				String funcionarioDevolve = scanLine.nextLine();

				System.out.println("\nDigite o nome do livro que irá devolver: ");
				String livroDevolve = scanLine.nextLine();

				System.out.println("\nDigite quantos dias a pessoa ficou com o livro: ");
				int diasDevolucao = t.nextInt();
				Colaborador devolveFuncionaria = null;
				Pessoa devolvePessoa = null;
				boolean encontrou = false;
				boolean encontrafuncao = false;

				System.out.println(PessoaDAO.getPessoa(pessoaDevolve));
				System.out.println(LivroDAO.getLivro(livroDevolve));

				for (Recepcionista rec : RecepcionistaDAO.recepcionistasList) {
					if (rec.getNome().equalsIgnoreCase(funcionarioDevolve)
							&& rec.getFuncao().toString().equalsIgnoreCase("Devolve Emprestimos")) {
						devolveFuncionaria = rec;
						encontrafuncao = true;
					}
				}
				for (Bibliotecario bibliotec : BibliotecarioDAO.bibliotecariosList) {
					if (bibliotec.getNome().equalsIgnoreCase(funcionarioDevolve)
							&& bibliotec.getFuncao().toString().equalsIgnoreCase("Devolve Emprestimos")) {
						devolveFuncionaria = bibliotec;
						encontrafuncao = true;
					}
				}

				for (Professor professor : ProfessorDAO.professoresList) {
					if (professor.getNome().equalsIgnoreCase(funcionarioDevolve)
							&& professor.getFuncao().toString().equalsIgnoreCase("Devolve Emprestimos")) {
						encontrafuncao = true;
						devolveFuncionaria = professor;
					}
				}

				for (Professor professor : ProfessorDAO.professoresList) {
					for (Aluno aluno : AlunoDAO.alunosList) {
						if (professor.getNome().equalsIgnoreCase(pessoaDevolve)) {
							devolvePessoa = professor;
							encontrou = true;
						} else if (aluno.getNome().equalsIgnoreCase(pessoaDevolve)) {
							devolvePessoa = aluno;
							encontrou = true;
						}
					}
				}

				if (encontrou && encontrafuncao) {
					devolveFuncionaria.executaFuncao();
					devolveFuncionaria.devolver(devolvePessoa, devolveFuncionaria, livroDevolve, diasDevolucao);
				} else {
					System.out.println(PessoaDAO.getPessoa(funcionarioDevolve));
				}
				break;

			case 5:
				System.out.println("\nDigite o nome da pessoa para ver seus empréstimos: ");
				String pessoaPesquisa = t.next();

				System.out.println(PessoaDAO.getPessoa(pessoaPesquisa));

				for (Professor professor : ProfessorDAO.professoresList) {
					if (professor.getNome().equalsIgnoreCase(pessoaPesquisa))
						System.out.println(professor.getEmprestimosRealizados());
				}
				for (Aluno aluno : AlunoDAO.alunosList) {
					if (aluno.getNome().equalsIgnoreCase(pessoaPesquisa)) {
						System.out.println(aluno.getEmprestimosRealizados());
					}
				}

				break;

			case 6:
				System.out.println("\nInsira o nome da pessoa para o serviço: ");
				String namePessoa = scanLine.nextLine();

				System.out.println("\n[1] - XEROX");
				System.out.println("[2] - IMPRESSÃO");

				int choice = t.nextInt();

				Pessoa pessoaPresente = null;

				boolean isAluno = false;
				boolean isBibliotecario = false;
				boolean isRecepcionista = false;
				boolean isProfessor = false;

				System.out.println("\nInsira a quantidade de páginas: ");
				int paginas = t.nextInt();

				System.out.println(PessoaDAO.getPessoa(namePessoa));

				for (Aluno aluno : AlunoDAO.alunosList) {
					for (Bibliotecario bibliotecario : BibliotecarioDAO.bibliotecariosList) {
						for (Professor professor : ProfessorDAO.professoresList) {
							for (Recepcionista recepcionista : RecepcionistaDAO.recepcionistasList) {
								if (aluno.getNome().equalsIgnoreCase(namePessoa)) {
									isAluno = true;
									pessoaPresente = aluno;
								} else if (bibliotecario.getNome().equalsIgnoreCase(namePessoa)) {
									isBibliotecario = true;
									pessoaPresente = bibliotecario;
								} else if (professor.getNome().equalsIgnoreCase(namePessoa)) {
									isProfessor = true;
									pessoaPresente = professor;
								} else if (recepcionista.getNome().equalsIgnoreCase(namePessoa)) {
									isRecepcionista = true;
									pessoaPresente = recepcionista;
								}
							}
						}
					}
				}

				switch (choice) {

				case 1:

					if (isAluno || isBibliotecario || isProfessor || isRecepcionista) {
						pessoaPresente.setQuantidadeFolha(paginas);
						System.out.println("\nEsta pessoa é nosso(a) " + pessoaPresente + ", favor cobrar: R$ "
								+ pessoaPresente.valorXeroxTotal() + "\n");
						papelaria.notifyObserver("Aguarde, copiando as páginas...");
					}

					break;

				case 2:

					if (isAluno || isBibliotecario || isProfessor || isRecepcionista) {
						pessoaPresente.setQuantidadeFolha(paginas);
						System.out.println("\nEsta pessoa é nosso(a) " + pessoaPresente + ", favor cobrar: R$ "
								+ pessoaPresente.valorImpressaoTotal() + "\n");
						papelaria.notifyObserver("Aguarde, imprimindo as páginas...");
					}

				default:
					break;
				}
				break;

			case 7:
				System.out.println("\n[1] - Matricular Aluno");
				System.out.println("[2] - Trancar matricula");
				System.out.println("[3] - Aluno formou");
				System.out.println("[4] - Aluno retornou\n");
				int alunoChoice = t.nextInt();

				switch (alunoChoice) {

				case 1:
					System.out.println("Digite o nome do aluno: ");
					String nomeAluno = t.next();
					System.out.println("Digite o codigo do aluno: ");
					int codAluno = t.nextInt();
					System.out.println("Digite o curso no qual vai matricular: ");
					String cursoAluno = scanLine.nextLine();
					boolean existe = false;

					for (Aluno aluno : AlunoDAO.alunosList) {
						if (nomeAluno.equalsIgnoreCase(aluno.getNome())) {
							existe = true;
						}
					}
					if (!existe) {
						Aluno novo = new Aluno(nomeAluno, codAluno, cursoAluno);
						novo.matricular();
						AlunoDAO.alunosList.add(novo);
					} else {
						System.out.println("Aluno ja existe");
					}
					break;

				case 2:
					System.out.println("Digite o nome do aluno: ");
					String nome = t.next();
					System.out.println(AlunoDAO.getAluno(nome));

					for (Aluno aluno : AlunoDAO.alunosList) {
						if (aluno.getNome().equalsIgnoreCase(nome)) {
							aluno.trancar();
						}
					}
					break;

				case 3:
					System.out.println("Digite o nome do aluno: ");
					String nome2 = t.next();
					System.out.println(AlunoDAO.getAluno(nome2));

					for (Aluno aluno : AlunoDAO.alunosList) {
						if (aluno.getNome().equalsIgnoreCase(nome2)) {
							aluno.formar();
						}
					}
					break;
				case 4:
					System.out.println("Digite o nome do aluno: ");
					String nome3 = t.next();
					System.out.println(AlunoDAO.getAluno(nome3));

					for (Aluno aluno : AlunoDAO.alunosList) {
						if (aluno.getNome().equalsIgnoreCase(nome3)) {
							aluno.retornar();
						}
					}
					break;
				default:
					break;

				}
				break;

			default:
				break;
			}

		}

	}

	public static void menu() {
		System.out.println("\n[1] - Listas");
		System.out.println("[2] - Gerenciar funcionarios");
		System.out.println("[3] - Emprestar livro");
		System.out.println("[4] - Devolver livro");
		System.out.println("[5] - Pesquisar empréstimos por nome");
		System.out.println("[6] - Serviço de xerox ou impressão");
		System.out.println("[7] - Gerenciar alunos\n");
	}

	public static void mudarProfissao(Colaborador colaborador) {
		System.out.println("\n[1] - Mudar para bibliotecario");
		System.out.println("[2] - Mudar para professor");
		System.out.println("[3] - Mudar para recepcionista");
		int profissao = t.nextInt();

		switch (profissao) {

		case 1:
			Servico biblioService = new CadastraEmprestimos();
			colaborador.recebeServico(biblioService);
			System.out.println("Agora o(a) funcionario(a) tem função de bibliotecario(a): " + colaborador);
			break;
		case 2:
			Servico profService = new MinistrarAula();
			colaborador.recebeServico(profService);
			System.out.println("Agora o(a) funcionario(a) tem função de professor(a): " + colaborador);
			break;
		case 3:
			Servico recepService = new DevolveEmprestimos();
			colaborador.recebeServico(recepService);
			System.out.println("Agora o(a) funcionario(a) tem função de recepcionista: " + colaborador);
			break;
		default:
			break;
		}
	}

	public static void addFuncionario() {
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
	}

	public static void mudarFuncaoFuncionario() {
		System.out.println("\nDigite o nome do funcionário que deseja mudar de função: ");
		String nomeColaborador = t.next();
		System.out.println(PessoaDAO.getPessoa(nomeColaborador));
		Colaborador escolhido = null;
		boolean isB = false;
		boolean isP = false;
		boolean isR = false;

		for (Recepcionista recepcionista : RecepcionistaDAO.recepcionistasList) {
			for (Professor professor : ProfessorDAO.professoresList) {
				for (Bibliotecario bibliotecario : BibliotecarioDAO.bibliotecariosList) {
					if (recepcionista.getNome().equalsIgnoreCase(nomeColaborador)) {
						escolhido = recepcionista;
						isR = true;
					} else if (professor.getNome().equalsIgnoreCase(nomeColaborador)) {
						escolhido = professor;
						isP = true;
					} else if (bibliotecario.getNome().equalsIgnoreCase(nomeColaborador)) {
						escolhido = bibliotecario;
						isB = true;
					}
				}
			}
		}
		if (isB || isP || isR) {
			mudarProfissao(escolhido);
		}

	}

	public static void pesquisaFuncionario() {
		System.out.println("Digite o nome de um funcionario para ver detalhes: ");
		String nomeFunc = t.next();
		boolean isBib = false;
		boolean isRecep = false;
		boolean isProf = false;

		Colaborador funcionario = null;

		for (Bibliotecario bib : BibliotecarioDAO.bibliotecariosList) {
			for (Recepcionista recep : RecepcionistaDAO.recepcionistasList) {
				for (Professor prof : ProfessorDAO.professoresList) {
					if (bib.getNome().equalsIgnoreCase(nomeFunc)) {
						isBib = true;
						funcionario = bib;
					} else if (recep.getNome().equalsIgnoreCase(nomeFunc)) {
						isRecep = true;
						funcionario = recep;
					} else if (prof.getNome().equalsIgnoreCase(nomeFunc)) {
						isProf = true;
						funcionario = prof;
					}
				}
			}
		}
		if (isBib || isRecep || isProf) {
			funcionario.executaFuncao();
			System.out.println(funcionario);
		} else {
			System.out.println(PessoaDAO.getPessoa(nomeFunc));
		}

	}

}
