package com.edu.ifsc.library.entities;

import java.util.ArrayList;
import java.util.List;

public class Aluno extends Pessoa {

	private String curso;
	private List<Emprestimo> emprestimosRealizados = new ArrayList<Emprestimo>();

	public Aluno(String nome, int codigo, String curso) {
		super(nome, codigo);
		this.curso = curso;
	}

	
	public Emprestimo getEmprestimo(String nomeLivro) {
		for (Emprestimo livro : emprestimosRealizados) {
			if (livro.getLivro().getNomeLivro().contentEquals(nomeLivro)) {
				return livro;
			}
		}
		return null;
	}

	public String getCurso() {
		return curso;
	}

	public void setCurso(String curso) {
		this.curso = curso;
	}

	@Override
	public String toString() {
		return "Aluno(a) " + nome + ", curso: " + curso + ".";
	}

	@Override
	public List<Emprestimo> getEmprestimosRealizados() {
		return emprestimosRealizados;
	}

}
