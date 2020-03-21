package com.edu.ifsc.library;

import java.util.Scanner;

import com.edu.ifsc.library.dao.AlunoDAO;
import com.edu.ifsc.library.dao.FuncionarioDAO;
import com.edu.ifsc.library.dao.LivroDAO;
import com.edu.ifsc.library.entities.Aluno;
import com.edu.ifsc.library.entities.Devolucao;
import com.edu.ifsc.library.entities.Emprestimo;
import com.edu.ifsc.library.entities.Funcionario;
import com.edu.ifsc.library.entities.Livro;
import com.edu.ifsc.library.entities.Pessoa;

public class Main {

	public static void main(String[] args) {
		Scanner t = new Scanner(System.in);
		Scanner livroScan = new Scanner(System.in);

		LivroDAO daoLivros = new LivroDAO();
		AlunoDAO daoAlunos = new AlunoDAO();
		FuncionarioDAO daoFuncionarios = new FuncionarioDAO();

		daoLivros.addLivros();
		daoAlunos.addAlunos();
		daoFuncionarios.addFuncionarios();

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
				System.out.println("Digite o nome do Funcionario: ");
				String nomeFuncionario = t.next();
				System.out.println("Digite o código do Funcionario: ");
				int codigoFuncionario = t.nextInt();
				System.out.println("Digite o setor do Funcionario: ");
				String setor = t.next();
				System.out.println("Digite a função do Funcionario: ");
				String funcao = t.next();
				FuncionarioDAO.funcionariosList.add(new Funcionario(nomeFuncionario, codigoFuncionario, setor, funcao));
				break;

			case 5:
				System.out.println("\nDigite o nome do aluno: ");
				String alunoNome = t.next();

				System.out.println("\nDigite o nome do bibliotecário: ");
				String funcionarioNome = t.next();

				System.out.println("\nDigite o nome do livro: ");
				String livroNome = livroScan.nextLine();

				System.out.println("\nDigite o número de dias de emprestímo: ");
				int dias = t.nextInt();

				System.out.println(AlunoDAO.getAluno(alunoNome));
				System.out.println(FuncionarioDAO.getFuncionario(funcionarioNome));
				System.out.println(LivroDAO.getLivro(livroNome));

				emprestar(alunoNome, funcionarioNome, livroNome, dias);

				break;

			case 6:
				System.out.println("\nDigite o nome do aluno que irá devolver um livro: ");
				String alunoDevolve = t.next();

				System.out.println("\nDigite o nome do livro que irá devolver: ");
				String livroDevolve = livroScan.nextLine();

				System.out.println("\nDigite quantos dias ficou com o livro: ");
				int diasDevolucao = t.nextInt();

				System.out.println(AlunoDAO.getAluno(alunoDevolve));
				System.out.println(LivroDAO.getLivro(livroDevolve));

				for (Aluno aluno : AlunoDAO.alunosList) {
					if (aluno.getNome().equalsIgnoreCase(alunoDevolve)) {
						for (int i = 0; i < aluno.getEmprestimosRealizados().size(); i++) {
							if (aluno.getEmprestimosRealizados().get(i).getLivro().getNomeLivro()
									.equalsIgnoreCase(livroDevolve)) {
								devolver(aluno, aluno.getEmprestimosRealizados().get(i), diasDevolucao);
							}
						}
					}
				}
				break;

			case 7:
				System.out.println("\nDigite o nome do aluno para pesquisar: ");
				String alunoPesquisa = t.next();
				System.out.println(AlunoDAO.getAluno(alunoPesquisa));
				for (Aluno aluno : AlunoDAO.alunosList) {
					if (aluno.getNome().equalsIgnoreCase(alunoPesquisa)) {
						System.out.println(aluno.getEmprestimosRealizados());
					}
				}

			case 8:
				System.out.println("Insira o nome da pessoa: ");
				String pessoaNome = t.next();
				System.out.println("[1] - XEROX");
				System.out.println("[2] - IMPRESSÃO");
				int choice = t.nextInt();

				System.out.println("Insira a quantidade de páginas: ");
				int paginas = t.nextInt();

				switch (choice) {

				case 1:
					for (Aluno aluno : AlunoDAO.alunosList) {
						for (Funcionario funcionario : FuncionarioDAO.funcionariosList) {
							if (aluno.getNome().equalsIgnoreCase(pessoaNome)) {
								aluno.setQuantidadeFolha(paginas);
								System.out.println(
										"\nEsta pessoa é nosso aluno(a), favor cobrar: R$ " + aluno.valorXeroxTotal());
							} else if (funcionario.getNome().equalsIgnoreCase(pessoaNome)) {
								funcionario.setQuantidadeFolha(paginas);
								System.out.println("\nEsta pessoa é nosso funcionario(a), favor cobrar: R$ "
										+ funcionario.valorXeroxTotal());
							} else {
								System.out.println(AlunoDAO.getAluno(pessoaNome));
							}
						}
					}
					break;

				case 2:
					for (Aluno aluno : AlunoDAO.alunosList) {
						for (Funcionario funcionario : FuncionarioDAO.funcionariosList) {
							if (aluno.getNome().equalsIgnoreCase(pessoaNome)) {
								aluno.setQuantidadeFolha(paginas);
								System.out.println("\nEsta pessoa é nosso aluno(a), favor cobrar: R$ "
										+ aluno.valorImpressaoTotal());
							} else if (funcionario.getNome().equalsIgnoreCase(pessoaNome)) {
								funcionario.setQuantidadeFolha(paginas);
								System.out.println("\nEsta pessoa é nosso funcionario(a), favor cobrar: R$ "
										+ funcionario.valorImpressaoTotal());
							} else {
								System.out.println(AlunoDAO.getAluno(pessoaNome));
							}
						}
					}
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
		System.out.println("\n[1] - Listar livros da Biblioteca");
		System.out.println("[2] - Adicionar livro");
		System.out.println("[3] - Adicionar aluno");
		System.out.println("[4] - Adicionar funcionario");
		System.out.println("[5] - Emprestar livro");
		System.out.println("[6] - Devolver livro");
		System.out.println("[7] - Pesquisar empréstimos por nome");
		System.out.println("[8] - Serviço de xerox ou impressão\n");
	}

	public static void devolver(Pessoa pessoa, Emprestimo emprestimo, int diasDePosse) {
		Devolucao devolver = new Devolucao(pessoa, emprestimo, diasDePosse);
		if (devolver.getDiasPosse() > emprestimo.getDiasEmprestimo()) {
			DevolucaoComAtraso atraso = new DevolucaoComAtraso(emprestimo);
			System.out.println(
					"O valor da devolução com multa ficou em: R$ " + devolver.executeStrategy(atraso) + " reais.");
		} else {
			DevolucaoSemAtraso semAtraso = new DevolucaoSemAtraso(emprestimo);
			System.out.println(
					"A devolução não teve multa, parabéns: R$ " + devolver.executeStrategy(semAtraso) + " reais.");
		}
		emprestimo.getLivro().setQuantidade(emprestimo.getLivro().getQuantidade() + 1);
		pessoa.getEmprestimosRealizados().remove(emprestimo);
		System.out.println("Devolução feita com sucesso!");

	}

	public static void emprestar(String nomeAluno, String nomeFuncionario, String nomeLivro, int diasEmprestimo) {
		for (Aluno aluno : AlunoDAO.alunosList) {
			for (Funcionario funcionario : FuncionarioDAO.funcionariosList) {
				for (Livro livro : LivroDAO.livrosBiblioteca) {
					if (aluno.getNome().equalsIgnoreCase(nomeAluno)
							&& funcionario.getNome().equalsIgnoreCase(nomeFuncionario)
							&& livro.getNomeLivro().equalsIgnoreCase(nomeFuncionario)) {
						aluno.getEmprestimosRealizados().add(new Emprestimo(aluno, funcionario, livro, diasEmprestimo));
						livro.setQuantidade(livro.getQuantidade() - 1);
						System.out.println("Emprestimo feito com sucesso!");
					}
				}
			}
		}
	}

}
