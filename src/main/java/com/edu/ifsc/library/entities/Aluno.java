package com.edu.ifsc.library.entities;

import com.edu.ifsc.library.AlunoState;

public class Aluno extends Pessoa {

	private String curso;
	private AlunoState estado;

	public Aluno(String nome, int codigo, String curso) {
		super(nome, codigo);
		this.curso = curso;
	}

	@Override
	protected double valorXeroxPorFolha() {
		return this.getQuantidadeFolha() * 0.05;
	}

	@Override
	protected double valorImpressaoPorFolha() {
		return this.getQuantidadeFolha() * 0.07;
	}

	public String getCurso() {
		return curso;
	}

	public void setCurso(String curso) {
		this.curso = curso;
	}

	public AlunoState getEstado() {
		return estado;
	}

	public void setEstado(AlunoState estado) {
		this.estado = estado;
	}

	@Override
	public String toString() {
		return "Aluno(a) " + nome + ", curso: " + curso;
	}

	public void matricular() {
		estado.matricular(this);
	}

	public void trancar() {
		estado.trancar(this);
	}

	public void formar() {
		estado.formar(this);
	}

	public void retornar() {
		estado.retornar(this);
	}

}
