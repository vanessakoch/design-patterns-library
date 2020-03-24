package com.edu.ifsc.library;

import com.edu.ifsc.library.entities.Aluno;

public class AlunoFormado implements AlunoState {

	public void matricular(Aluno aluno) {
		return;
	}

	public void trancar(Aluno aluno) {
		return;		
	}

	public void formar(Aluno aluno) {
		return;		
	}

	public String getState() {
		return "formado";
	}
	
	public void retornar(Aluno aluno) {
		return;		
	}


	
}
