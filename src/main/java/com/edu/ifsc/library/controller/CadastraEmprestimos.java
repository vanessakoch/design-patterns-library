package com.edu.ifsc.library.controller;

import com.edu.ifsc.library.dao.AlunoDAO;
import com.edu.ifsc.library.dao.LivroDAO;
import com.edu.ifsc.library.dao.ProfessorDAO;
import com.edu.ifsc.library.entities.Aluno;
import com.edu.ifsc.library.entities.AtividadeBiblioteca;
import com.edu.ifsc.library.entities.Colaborador;
import com.edu.ifsc.library.entities.Dispositivo;
import com.edu.ifsc.library.entities.Emprestimo;
import com.edu.ifsc.library.entities.Livro;
import com.edu.ifsc.library.entities.LivroAusente;
import com.edu.ifsc.library.entities.LivroState;
import com.edu.ifsc.library.entities.Pessoa;
import com.edu.ifsc.library.entities.Professor;
import com.edu.ifsc.library.entities.Servico;

public class CadastraEmprestimos implements Servico {

	public void realizaEmprestimo(String nomePessoa, Colaborador funcionario, String nomeLivro, int diasEmprestimo,
			int escolhePessoa) {

		AtividadeBiblioteca servico = new AtividadeBiblioteca("Dept. Bibliotecário");
		
		Dispositivo monitor = new Dispositivo("Monitor");
		Dispositivo email = new Dispositivo("Email");
		servico.registraObserver(monitor);
		servico.registraObserver(email);

		switch (escolhePessoa) {

		case 1:
			for (Professor professor : ProfessorDAO.professoresList) {
				for (Livro livro : LivroDAO.livrosBiblioteca) {
					if (professor.getNome().equalsIgnoreCase(nomePessoa)
							& livro.getNomeLivro().equalsIgnoreCase(nomeLivro)) {
						if (livro.getQuantidade() == 1) {
							professor.getEmprestimosRealizados()
									.add(new Emprestimo(professor, funcionario, livro, diasEmprestimo));
							livro.setQuantidade(0);
							LivroState emprestimoState = new Emprestimo();
							emprestimoState.onAction(livro);
							System.out.println(livro + "\n");
							
							servico.notifyObserver("O livro " + livro.getNomeLivro() + " estará ausente por "
									+ "aproximadamente " + diasEmprestimo + " dias.");

						} else {
							LivroState ausenteState = new LivroAusente();
							ausenteState.onAction(livro);
							System.out.println();
							servico.notifyObserver("O livro " + livro.getNomeLivro() + " está ausente");
						}
					}
				}
			}

			break;

		case 2:
			for (Aluno aluno : AlunoDAO.alunosList) {
				for (Livro livro : LivroDAO.livrosBiblioteca) {
					if (aluno.getNome().equalsIgnoreCase(nomePessoa)
							&& livro.getNomeLivro().equalsIgnoreCase(nomeLivro)) {
						if (livro.getQuantidade() == 1) {
							if (!aluno.getEstado().getState().equals("trancado")
									&& !aluno.getEstado().getState().equals("formado")) {
								aluno.getEmprestimosRealizados()
										.add(new Emprestimo(aluno, funcionario, livro, diasEmprestimo));
								livro.setQuantidade(0);
								LivroState emprestimoState = new Emprestimo();
								emprestimoState.onAction(livro);
								System.out.println(livro + "\n");
								servico.notifyObserver("O livro " + livro.getNomeLivro() + " estará ausente por "
										+ "aproximadamente " + diasEmprestimo + " dias.");

							} else {
								System.out.println("\nAluno está com a matricula trancada ou ja se formou!");
							}

						} else {
							LivroState ausenteState = new LivroAusente();
							ausenteState.onAction(livro);
							servico.notifyObserver("O livro " + livro.getNomeLivro() + " está ausente");
						}
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

	public void devolverEmprestimo(Pessoa pessoa, Colaborador funcionario, String livro, int diasDePosse) {
		System.out.println("Este funcionario faz cadastro, não devolução!");

	}

	@Override
	public String toString() {
		return "Cadastra Emprestimos";
	}
}
