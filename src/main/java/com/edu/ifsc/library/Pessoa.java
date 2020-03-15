package com.edu.ifsc.library;

import java.util.ArrayList;
import java.util.List;

public abstract class Pessoa {
	private String nome;
	private String cpf;
	private int codigo;
	private List<Emprestimo> emprestimosRealizados = new ArrayList<Emprestimo>();

	public Pessoa(String nome, String cpf, int codigo) {
		super();
		this.nome = nome;
		this.cpf = cpf;
		this.codigo = codigo;
	}

	public List<Emprestimo> getEmprestimosRealizados() {
		return emprestimosRealizados;
	}

	public Emprestimo getEmprestimo(String nomeLivro) {
		for (Emprestimo livro : emprestimosRealizados) {
			if (livro.getLivro().getNomeLivro().contentEquals(nomeLivro)) {
				return livro;
			}
		}
		return null;
	}

	public void setEmprestimosRealizados(List<Emprestimo> emprestimosRealizados) {
		this.emprestimosRealizados = emprestimosRealizados;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public int getCodigo() {
		return codigo;
	}

	@Override
	public String toString() {
		return nome;
	}

}
