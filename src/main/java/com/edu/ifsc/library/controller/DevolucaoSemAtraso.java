package com.edu.ifsc.library.controller;

import com.edu.ifsc.library.entities.Emprestimo;

public class DevolucaoSemAtraso implements InterfaceCalculoDevolucao {

	private Emprestimo emprestimo;

	public DevolucaoSemAtraso(Emprestimo emprestimo) {
		super();
		this.emprestimo = emprestimo;
	}

	public double calcular(Emprestimo emprestimo, int diasPosse) {
		return 0;
	}

	public Emprestimo getEmprestimo() {
		return emprestimo;
	}

	public void setEmprestimo(Emprestimo emprestimo) {
		this.emprestimo = emprestimo;
	}

}