package com.edu.ifsc.library;

public class Livro {
	private String nomeLivro;
	private String autor;
	private int ano;
	private int quantidade;
	private boolean status;

	public Livro(String nomeLivro, String autor, int ano, int quantidade, boolean status) {
		super();
		this.nomeLivro = nomeLivro;
		this.autor = autor;
		this.ano = ano;
		this.quantidade = quantidade;
		this.status = status;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
		if(this.quantidade > 0) 
			this.setStatus(true);
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public String getNomeLivro() {
		return nomeLivro;
	}

	public String getAutor() {
		return autor;
	}

	public int getAno() {
		return ano;
	}

	@Override
	public String toString() {
		return "Livro: " + nomeLivro + ", autor: " + autor + ", ano: " + ano
				+ ", quantidade: " + quantidade + ", status: " + status + ".";
	}

	
	
}
