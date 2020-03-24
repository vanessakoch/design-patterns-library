package com.edu.ifsc.library;

import com.edu.ifsc.library.entities.Livro;

public interface LivroState {
	
	public void onAction(Livro livro);
	
	public String imprimirState();
	
}
