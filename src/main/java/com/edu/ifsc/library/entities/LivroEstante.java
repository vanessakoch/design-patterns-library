package com.edu.ifsc.library.entities;

public class LivroEstante implements LivroState {

	public LivroEstante() {
	}

	public void onAction(Livro livro) {
		livro.setState(this);
	}

	public String imprimirState() {
		return "Livro está na estante";
	}

}
