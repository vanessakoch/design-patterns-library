package com.edu.ifsc.library;

import com.edu.ifsc.library.entities.Aluno;

public interface AlunoState {

	public void matricular(Aluno aluno);
    public void trancar(Aluno aluno); 
    public void formar(Aluno aluno);
    public void retornar(Aluno aluno);
    public String getState();
	
}
