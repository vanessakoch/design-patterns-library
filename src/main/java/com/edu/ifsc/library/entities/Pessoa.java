package com.edu.ifsc.library.entities;


import java.util.ArrayList;
import java.util.List;

import com.edu.ifsc.library.AbstractPessoa;

public abstract class Pessoa extends AbstractPessoa {
	protected String nome;
	private int codigo;
	private int quantidadeFolha;
	private List<Emprestimo> emprestimosRealizados = new ArrayList<Emprestimo>();


	public Pessoa(String nome, int codigo) {
		super();
		this.nome = nome;
		this.codigo = codigo;
	}

	protected abstract double valorXeroxPorFolha();

	protected abstract double valorImpressaoPorFolha();

	public double valorXeroxTotal() {
		return valorXeroxPorFolha() * quantidadeFolha;
	}
	
	public double valorImpressaoTotal() {
		return valorImpressaoPorFolha() * quantidadeFolha;
	}
	
	public Emprestimo getEmprestimo(String nomeLivro) {
		for (Emprestimo livro : emprestimosRealizados) {
			if (livro.getLivro().getNomeLivro().contentEquals(nomeLivro)) {
				return livro;
			}
		}
		return null;
	}

	public List<Emprestimo> getEmprestimosRealizados() {
		return emprestimosRealizados;
	}
	
	@Override
	public String getNome() {
		return nome;
	}

	@Override
	public Integer getCodigo() {
		return codigo;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@Override
	public String toString() {
		return nome + ", código: " + codigo;
	}

	public int getQuantidadeFolha() {
		return quantidadeFolha;
	}

	public void setQuantidadeFolha(int quantidadeFolha) {
		this.quantidadeFolha = quantidadeFolha;
	}

	
}
