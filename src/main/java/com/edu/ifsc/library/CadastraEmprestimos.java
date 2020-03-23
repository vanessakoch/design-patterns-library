package com.edu.ifsc.library;

import com.edu.ifsc.library.dao.AlunoDAO;
import com.edu.ifsc.library.dao.BibliotecarioDAO;
import com.edu.ifsc.library.dao.LivroDAO;
import com.edu.ifsc.library.entities.Aluno;
import com.edu.ifsc.library.entities.Bibliotecario;
import com.edu.ifsc.library.entities.Emprestimo;
import com.edu.ifsc.library.entities.Livro;
import com.edu.ifsc.library.entities.Pessoa;

public class CadastraEmprestimos implements Servico {

	public void realizaEmprestimo(String nomePessoa, Bibliotecario funcionario, String nomeLivro, int diasEmprestimo,
			int escolhePessoa) {
		switch (escolhePessoa) {

		case 1:
			System.out.println(BibliotecarioDAO.getBibliotecario(nomePessoa));
			System.out.println(LivroDAO.getLivro(nomeLivro));

			for (Bibliotecario bibliotecario : BibliotecarioDAO.bibliotecariosList) {
				for (Livro livro : LivroDAO.livrosBiblioteca) {
					if (bibliotecario.getNome().equalsIgnoreCase(nomePessoa)
							& livro.getNomeLivro().equalsIgnoreCase(nomeLivro)) {

						bibliotecario.getEmprestimosRealizados()
								.add(new Emprestimo(bibliotecario, bibliotecario, livro, diasEmprestimo));
						livro.setQuantidade(livro.getQuantidade() - 1);
						System.out.println("Emprestimo feito com sucesso!");
					}

				}

			}
			break;

		case 2:
			System.out.println(AlunoDAO.getAluno(nomePessoa));
			System.out.println(LivroDAO.getLivro(nomeLivro));

			for (Aluno aluno : AlunoDAO.alunosList) {
				for (Livro livro : LivroDAO.livrosBiblioteca) {
					if (aluno.getNome().equalsIgnoreCase(nomePessoa)
							&& livro.getNomeLivro().equalsIgnoreCase(nomeLivro)) {
						aluno.getEmprestimosRealizados().add(new Emprestimo(aluno, funcionario, livro, diasEmprestimo));
						livro.setQuantidade(livro.getQuantidade() - 1);
						System.out.println("Emprestimo feito com sucesso!");
					}
				}
			}

			break;

		default:
			break;
		}

	}

	public void produz() {
		System.out.println("Trabalhando com empréstimos de livros");
	}

	public void devolverEmprestimo(Pessoa pessoa, Emprestimo emprestimo, int diasDePosse) {
		System.out.println("Este funcionario faz cadastro, não devolução!");

	}
}
