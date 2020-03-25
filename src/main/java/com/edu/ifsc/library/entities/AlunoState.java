package com.edu.ifsc.library.entities;

public interface AlunoState {

	public void matricular(Aluno aluno);
    public void trancar(Aluno aluno); 
    public void formar(Aluno aluno);
    public void retornar(Aluno aluno);
    public String getState();
	
}
