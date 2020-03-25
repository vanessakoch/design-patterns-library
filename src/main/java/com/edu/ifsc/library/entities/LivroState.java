package com.edu.ifsc.library.entities;

public interface LivroState {
	
	public void onAction(Livro livro);
	
	public String imprimirState();
	
}
