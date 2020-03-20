package com.edu.ifsc.library.dao;

import java.util.ArrayList;
import java.util.List;

import com.edu.ifsc.library.AbstractLivro;
import com.edu.ifsc.library.entities.Livro;
import com.edu.ifsc.library.entities.LivroNull;

public class LivroDAO {
	public static List<Livro> livrosBiblioteca = new ArrayList<Livro>();

	public void addLivros() {
		livrosBiblioteca.add(new Livro("Doctor Sleep", "Stephen King", 2013, 10));
		livrosBiblioteca.add(new Livro("The Shinning", "Stephen King", 1977, 5));
	}

	public static AbstractLivro getLivro(String nome) {
		for (Livro livros : livrosBiblioteca) {
			if (nome.equals(livros.getNomeLivro()))
				return new Livro(livros.getNomeLivro(), livros.getAutorLivro(), livros.getAnoLivro(),
						livros.getQuantidade());
		}
		return new LivroNull();

	}

}
