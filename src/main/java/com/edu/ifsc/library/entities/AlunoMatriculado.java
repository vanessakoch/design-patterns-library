package com.edu.ifsc.library.entities;

public class AlunoMatriculado implements AlunoState {

	public void matricular(Aluno aluno) {
		return;
	}

	public void trancar(Aluno aluno) {
		aluno.setEstado(new AlunoTrancado());
	}

	public void formar(Aluno aluno) {
		aluno.setEstado(new AlunoFormado());
	}

	public void retornar(Aluno aluno) {
		return;
	}

	public String getState() {
		return "matriculado";
	}

}
