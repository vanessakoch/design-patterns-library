package com.edu.ifsc.library.entities;

public class LivroNull extends AbstractLivro {

	@Override
	public String getNomeLivro() {
		return "Ainda não temos este livro na biblioteca.";
	}

	@Override
	public String getAutorLivro() {
		return null;
	}

	@Override
	public Integer getAnoLivro() {
		return null;
	}

	@Override
	public Integer getQuantidade() {
		return null;
	}

	@Override
	public String toString() {
		return getNomeLivro();
	}

}
