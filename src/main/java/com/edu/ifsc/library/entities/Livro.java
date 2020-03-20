package com.edu.ifsc.library.entities;

import com.edu.ifsc.library.AbstractLivro;

public class Livro extends AbstractLivro {
	private String nomeLivro;
	private String autor;
	private int ano;
	private int quantidade;

	public Livro(String nomeLivro, String autor, int ano, int quantidade) {
		super();
		this.nomeLivro = nomeLivro;
		this.autor = autor;
		this.ano = ano;
		this.quantidade = quantidade;
	}

	@Override
	public String getNomeLivro() {
		return nomeLivro;
	}

	@Override
	public String getAutorLivro() {
		return autor;
	}

	@Override
	public Integer getAnoLivro() {
		return ano;
	}

	@Override
	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	@Override
	public String toString() {
		return "Livro " + nomeLivro + ", autor: " + autor + ", ano: " + ano + ", quantidade: " + quantidade
				+ ".";
	}

}
