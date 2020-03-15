package com.edu.ifsc.library;

public class Emprestimo {
	private Pessoa cliente;
	private Funcionario funcionario;
	private Livro livro;
	private int diasEmprestimo;

	public Emprestimo(Pessoa cliente, Funcionario funcionario, Livro livro, int diasEmprestimo) {
		super();
		this.cliente = cliente;
		this.funcionario = funcionario;
		this.livro = livro;
		this.diasEmprestimo = diasEmprestimo;
	}
	
	public Pessoa getCliente() {
		return cliente;
	}

	public void setCliente(Pessoa cliente) {
		this.cliente = cliente;
	}

	public Livro getLivro() {
		return livro;
	}

	public void setLivro(Livro livro) {
		this.livro = livro;
	}

	public int getDiasEmprestimo() {
		return diasEmprestimo;
	}

	public void setDiasEmprestimo(int diasEmprestimo) {
		this.diasEmprestimo = diasEmprestimo;
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	@Override
	public String toString() {
		return "Emprestimo de: " + cliente + ", livro: " + livro.getNomeLivro() + ", quantidade de dias: " + diasEmprestimo;
	}	
	
	
	
}
