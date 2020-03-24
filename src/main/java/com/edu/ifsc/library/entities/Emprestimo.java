package com.edu.ifsc.library.entities;

import com.edu.ifsc.library.LivroState;

public class Emprestimo implements LivroState {
	private Pessoa cliente;
	private Bibliotecario funcionario;
	private Livro livro;
	private int diasEmprestimo;

	public Emprestimo(Pessoa cliente, Bibliotecario funcionario, Livro livro, int diasEmprestimo) {
		super();
		this.cliente = cliente;
		this.funcionario = funcionario;
		this.livro = livro;
		this.diasEmprestimo = diasEmprestimo;
	}

	public Emprestimo() {

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

	public Bibliotecario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Bibliotecario funcionario) {
		this.funcionario = funcionario;
	}

	@Override
	public String toString() {
		return "\nEmprestimo de: " + cliente.getNome() + ", livro: " + livro.getNomeLivro() + ", quantidade de dias: "
				+ diasEmprestimo + "\n";
	}

	public void onAction(Livro livro) {
		livro.setState(this);
	}

	public String imprimirState() {
		return "Livro emprestado";
	}

}
