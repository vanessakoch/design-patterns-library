package com.edu.ifsc.library;

public class Professor extends Pessoa {
	private String materia;

	public Professor(String nome, String cpf, int codigo, String materia) {
		super(nome, cpf, codigo);
		this.materia = materia;
	}

	public String getMateria() {
		return materia;
	}

	public void setMateria(String materia) {
		this.materia = materia;
	}

}
