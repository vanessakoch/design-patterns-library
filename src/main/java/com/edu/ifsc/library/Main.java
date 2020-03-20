package com.edu.ifsc.library;

import java.util.ArrayList;
import java.util.List;
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
				for (Livro livros : LivroDAO.livrosBiblioteca) {
					System.out.println(livros);
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
				String name = t.next();

				System.out.println("\nDigite o nome do bibliotecário: ");
				String nomeFunc = t.next();
				
				System.out.println("\nDigite o nome do livro: ");
				String nomeBook = livroScan.nextLine();
				
				System.out.println("\nDigite o número de dias de emprestímo: ");
				int dias = t.nextInt();
				
				System.out.println(AlunoDAO.getAluno(name));
				System.out.println(FuncionarioDAO.getFuncionario(nomeFunc));
				System.out.println(LivroDAO.getLivro(nomeBook));
				
				for (Aluno aluno : AlunoDAO.alunosList) {
					for (Funcionario funcionario : FuncionarioDAO.funcionariosList) {
						for (Livro livro : LivroDAO.livrosBiblioteca) {
							if (aluno.getNome().equalsIgnoreCase(name)
									&& funcionario.getNome().equalsIgnoreCase(nomeFunc)
									&& livro.getNomeLivro().equalsIgnoreCase(nomeBook)) {
								aluno.getEmprestimosRealizados().add(new Emprestimo(aluno, funcionario, livro, dias));
								livro.setQuantidade(livro.getQuantidade()-1);
								System.out.println("Emprestimo feito com sucesso!");
							}
						}
					}
				}

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
					for (Emprestimo emprestimo : aluno.getEmprestimosRealizados()) {
						if (aluno.getNome().equalsIgnoreCase(alunoDevolve)
								&& emprestimo.getLivro().getNomeLivro().equalsIgnoreCase(livroDevolve)) {
							devolver(aluno, emprestimo, diasDevolucao);
							emprestimo.getLivro().setQuantidade(emprestimo.getLivro().getQuantidade()+1);
							System.out.println("Devolução feita com sucesso!");
							//aluno.getEmprestimosRealizados().remove(emprestimo);

						}
					}
				}
				break;
			case 7:
				System.out.println("\nDigite o nome do aluno para pesquisar: ");
				String alunoPesquisa = t.next();
				System.out.println(AlunoDAO.getAluno(alunoPesquisa));
				for(Aluno aluno : AlunoDAO.alunosList) {
					if(aluno.getNome().equalsIgnoreCase(alunoPesquisa)) {
						System.out.println(aluno.getEmprestimosRealizados());
					}
				}
				
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
		System.out.println("[7] - Pesquisar empréstimos por nome\n");

	}

	public static void devolver(Pessoa pessoa, Emprestimo emprestimo, int diasDePosse) {
		Devolucao devolver = new Devolucao(pessoa, emprestimo, diasDePosse);
		if (devolver.getDiasPosse() > emprestimo.getDiasEmprestimo()) {
			DevolucaoComAtraso atraso = new DevolucaoComAtraso(emprestimo);
			System.out.println("O valor da devolução com multa ficou em: R$ " + devolver.executeStrategy(atraso) + " reais.");
		} else {
			DevolucaoSemAtraso semAtraso = new DevolucaoSemAtraso(emprestimo);
			System.out.println("A devolução não teve multa, parabéns: R$ " + devolver.executeStrategy(semAtraso) + " reais.");
		}
	}

}
