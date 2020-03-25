package com.edu.ifsc.library.dao;

import java.util.ArrayList;
import java.util.List;

import com.edu.ifsc.library.entities.AbstractLivro;
import com.edu.ifsc.library.entities.Livro;
import com.edu.ifsc.library.entities.LivroNull;

public class LivroDAO {
	public static List<Livro> livrosBiblioteca = new ArrayList<Livro>();

	public void addLivros() {
		livrosBiblioteca.add(new Livro("Java", 3, "Stephen King", 2013));
		livrosBiblioteca.add(new Livro("C++", 1,"Stephen King", 1977));
		livrosBiblioteca.add(new Livro("Python", 1,"Stephen King", 1990));
		livrosBiblioteca.add(new Livro("Ruby", 1,"Stephen King", 1975));
		livrosBiblioteca.add(new Livro("JavaScript", 1,"Stephen King", 2011));
	}

	public static AbstractLivro getLivro(String nome) {
		for (Livro livros : livrosBiblioteca) {
			if (nome.equalsIgnoreCase(livros.getNomeLivro()))
				return new Livro(livros.getNomeLivro(), livros.getEdicao(), livros.getAutorLivro(), livros.getAnoLivro());
		}
		return new LivroNull();

	}

}
