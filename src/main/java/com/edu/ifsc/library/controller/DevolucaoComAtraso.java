package com.edu.ifsc.library.controller;

import com.edu.ifsc.library.entities.Emprestimo;

public class DevolucaoComAtraso implements InterfaceCalculoDevolucao {
	private Emprestimo emprestimo;

	public DevolucaoComAtraso(Emprestimo emprestimo) {
		super();
		this.emprestimo = emprestimo;
	}

	public double calcular(Emprestimo emprestimo, int diasPosse) {
		double valorMulta = (emprestimo.getDiasEmprestimo() + diasPosse) * 0.03;

		return valorMulta ;
	}

	public Emprestimo getEmprestimo() {
		return emprestimo;
	}

	public void setEmprestimo(Emprestimo emprestimo) {
		this.emprestimo = emprestimo;
	}

}
