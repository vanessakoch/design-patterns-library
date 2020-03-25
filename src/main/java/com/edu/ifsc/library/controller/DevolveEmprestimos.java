package com.edu.ifsc.library.controller;

import com.edu.ifsc.library.entities.AtividadeBiblioteca;
import com.edu.ifsc.library.entities.Bibliotecario;
import com.edu.ifsc.library.entities.Colaborador;
import com.edu.ifsc.library.entities.Devolucao;
import com.edu.ifsc.library.entities.Dispositivo;
import com.edu.ifsc.library.entities.Emprestimo;
import com.edu.ifsc.library.entities.Pessoa;
import com.edu.ifsc.library.entities.Recepcionista;
import com.edu.ifsc.library.entities.Servico;

public class DevolveEmprestimos implements Servico {

	public void produz() {
		System.out.println("Trabalhando com devoluções de livros");
	}

	public void realizaEmprestimo(String nomePessoa, Colaborador nomeFuncionario, String nomeLivro,
			int diasEmprestimo, int escolhePessoa) {
		System.out.println("Este funcionario faz devolucao, não cadastro!");
	}

	public void devolverEmprestimo(Pessoa pessoa, Colaborador funcionario, String livroNome, int diasDePosse) {
		AtividadeBiblioteca servico = new AtividadeBiblioteca("Recepção");

		Dispositivo monitor = new Dispositivo("Monitor");
		Dispositivo celular = new Dispositivo("Celular Recepção");

		servico.registraObserver(monitor);
		servico.registraObserver(celular);

		Emprestimo emprestimoLivro = null;
		boolean livroEmprestado = false;

		for (int i = 0; i < pessoa.getEmprestimosRealizados().size(); i++) {
			if (pessoa.getEmprestimosRealizados().get(i).getLivro().getNomeLivro().equalsIgnoreCase(livroNome)) {
				emprestimoLivro = pessoa.getEmprestimosRealizados().get(i);
				livroEmprestado = true;
			}
		}

		if (livroEmprestado) {
			Devolucao devolver = new Devolucao(pessoa, emprestimoLivro, diasDePosse);
			devolver.onAction(emprestimoLivro.getLivro());

			if (devolver.getDiasPosse() > emprestimoLivro.getDiasEmprestimo()) {

				DevolucaoComAtraso atraso = new DevolucaoComAtraso(emprestimoLivro);
				System.out.println(emprestimoLivro.getLivro() + "\n");
				servico.notifyObserver(
						"O valor da devolução com multa ficou em: R$ " + devolver.executeStrategy(atraso) + " reais.");

			} else {

				DevolucaoSemAtraso semAtraso = new DevolucaoSemAtraso(emprestimoLivro);
				System.out.println(emprestimoLivro.getLivro() + "\n");
				servico.notifyObserver(
						"A devolução não teve multa, parabéns: R$ " + devolver.executeStrategy(semAtraso) + " reais.");

			}
			emprestimoLivro.getLivro().setQuantidade(emprestimoLivro.getLivro().getQuantidade() + 1);
			pessoa.getEmprestimosRealizados().remove(emprestimoLivro);
		}
	}

	@Override
	public String toString() {
		return "Devolve Emprestimos";
	}
}
