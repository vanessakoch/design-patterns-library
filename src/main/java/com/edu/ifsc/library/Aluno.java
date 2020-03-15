package com.edu.ifsc.library;


public class Aluno extends Pessoa {

	private String curso;

	public Aluno(String nome, String cpf, int codigo, String curso) {
		super(nome, cpf, codigo);
		this.curso = curso;
	}

	public String getCurso() {
		return curso;
	}

	public void setCurso(String curso) {
		this.curso = curso;
	}
	

}
