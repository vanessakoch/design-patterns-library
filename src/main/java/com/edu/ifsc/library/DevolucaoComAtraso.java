package com.edu.ifsc.library;

public class DevolucaoComAtraso implements InterfaceCalculoDevolucao {
	private Emprestimo emprestimo;

	public DevolucaoComAtraso(Emprestimo emprestimo) {
		super();
		this.emprestimo = emprestimo;
	}

	public double calcular(Emprestimo emprestimo, int diasPosse) {
		double valorMulta = emprestimo.getDiasEmprestimo() + diasPosse;

		return valorMulta * 0.30;
	}

	public Emprestimo getEmprestimo() {
		return emprestimo;
	}

	public void setEmprestimo(Emprestimo emprestimo) {
		this.emprestimo = emprestimo;
	}

}
