package com.edu.ifsc.library;

import com.edu.ifsc.library.entities.Bibliotecario;
import com.edu.ifsc.library.entities.Devolucao;
import com.edu.ifsc.library.entities.Emprestimo;
import com.edu.ifsc.library.entities.Pessoa;

public class DevolveEmprestimos implements Servico {

	public void produz() {
		System.out.println("Trabalhando com devoluções de livros");
	}

	public void realizaEmprestimo(String nomePessoa, Bibliotecario nomeFuncionario, String nomeLivro,
			int diasEmprestimo, int escolhePessoa) {
		System.out.println("Este funcionario faz devolucao, não cadastro!");
	}

	public void devolverEmprestimo(Pessoa pessoa, Emprestimo emprestimo, int diasDePosse) {
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

}
