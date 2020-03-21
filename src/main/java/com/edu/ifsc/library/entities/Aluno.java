package com.edu.ifsc.library.entities;


public class Aluno extends Pessoa {

	private String curso;

	public Aluno(String nome, int codigo, String curso) {
		super(nome, codigo);
		this.curso = curso;
	}

	@Override
	protected double valorXeroxPorFolha() {
		return this.getQuantidadeFolha() * 0.03;
	}
	
	@Override
	protected double valorImpressaoPorFolha() {
		return this.getQuantidadeFolha() * 0.05;
	}
	
	public String getCurso() {
		return curso;
	}

	public void setCurso(String curso) {
		this.curso = curso;
	}

	@Override
	public String toString() {
		return "Aluno(a) " + nome + ", curso: " + curso;
	}



}
