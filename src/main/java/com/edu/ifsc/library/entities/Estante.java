package com.edu.ifsc.library.entities;

import com.edu.ifsc.library.LivroState;


public class Estante implements LivroState {

	public Estante() {
	}

	public void onAction(Livro livro) {
		livro.setState(this);
	}

	public String imprimirState() {
		return "Livro está na estante";
	}

}
