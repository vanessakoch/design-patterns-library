package com.edu.ifsc.library.entities;

public class LivroAusente implements LivroState {

	public LivroAusente() {

	}

	public void onAction(Livro livro) {
		livro.setState(this);
	}

	public String imprimirState() {
		return "Livro está ausente";
	}

}
