package com.edu.ifsc.library;

public class Main {

	public static void main(String[] args) {

		Pessoa vanessa = new Aluno("Vanessa", "123", 1, "ADS");
		Livro livro1 = new Livro("Doctor Sleep", "Stephen King", 2013, 10, true);
		Funcionario bibliotecaria = new Funcionario("Andreia", "123", 2, "Bibliotecaria",
				"Responsável pelos emprestimos");

		Emprestimo novo = new Emprestimo(vanessa, bibliotecaria, livro1, 5);
		vanessa.getEmprestimosRealizados().add(novo);

		devolver(vanessa, vanessa.getEmprestimo("Doctor Sleep"), 5);

	}

	public static void devolver(Pessoa pessoa, Emprestimo emprestimo, int diasDePosse) {
		Devolucao devolver = new Devolucao(pessoa, emprestimo, diasDePosse);
		if (devolver.getDiasPosse() > emprestimo.getDiasEmprestimo()) {
			DevolucaoComAtraso atraso = new DevolucaoComAtraso(emprestimo);
			System.out.println("Valor da devolução: R$ " + devolver.executeStrategy(atraso));
		} else {
			DevolucaoSemAtraso atraso = new DevolucaoSemAtraso(emprestimo);
			System.out.println("Valor da devolução: R$ " + devolver.executeStrategy(atraso));
		}
	}

}
