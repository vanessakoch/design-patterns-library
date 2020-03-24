package com.edu.ifsc.library.entities;

import com.edu.ifsc.library.LivroState;

public class Ausente implements LivroState {

	public Ausente() {

	}

	public void onAction(Livro livro) {
		livro.setState(this);
	}

	public String imprimirState() {
		return "Livro está ausente";
	}

}
