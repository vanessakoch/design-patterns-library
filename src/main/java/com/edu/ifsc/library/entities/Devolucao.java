package com.edu.ifsc.library.entities;

import com.edu.ifsc.library.InterfaceCalculoDevolucao;

public class Devolucao {
	private Pessoa cliente;
	private Emprestimo emprestimo;
	private int diasPosse;
	private InterfaceCalculoDevolucao calcularEmprestimo;

	public Devolucao(Pessoa cliente, Emprestimo emprestimo, int diasPosse) {
		super();
		this.cliente = cliente;
		this.emprestimo = emprestimo;
		this.diasPosse = diasPosse;
	}

	public double executeStrategy(InterfaceCalculoDevolucao calcularEmprestimo) {
		return calcularEmprestimo.calcular(emprestimo, diasPosse);
	}

	public Pessoa getCliente() {
		return cliente;
	}

	public void setCliente(Pessoa cliente) {
		this.cliente = cliente;
	}

	public Emprestimo getEmprestimo() {
		return emprestimo;
	}

	public void setEmprestimo(Emprestimo emprestimo) {
		this.emprestimo = emprestimo;
	}

	public int getDiasPosse() {
		return diasPosse;
	}

	public void setDiasPosse(int diasPosse) {
		this.diasPosse = diasPosse;
	}

	public InterfaceCalculoDevolucao getCalcularEmprestimo() {
		return calcularEmprestimo;
	}

	public void setCalcularEmprestimo(InterfaceCalculoDevolucao calcularEmprestimo) {
		this.calcularEmprestimo = calcularEmprestimo;
	}

}
