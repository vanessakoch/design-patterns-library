package com.edu.ifsc.library;

import com.edu.ifsc.library.entities.Aluno;

public class AlunoTrancado implements AlunoState {

	public void matricular(Aluno aluno) {
		aluno.setEstado(new AlunoMatriculado());
	}

	public void trancar(Aluno aluno) {
		return;
	}

	public void formar(Aluno aluno) {
		return;
	}

	public void retornar(Aluno aluno) {
		aluno.setEstado(new AlunoMatriculado());
	}

	public String getState() {
		return "trancado";
	}

}
