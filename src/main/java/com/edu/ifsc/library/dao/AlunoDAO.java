package com.edu.ifsc.library.dao;

import java.util.ArrayList;
import java.util.List;
import com.edu.ifsc.library.AbstractPessoa;
import com.edu.ifsc.library.entities.Aluno;

import com.edu.ifsc.library.entities.PessoaNull;

public class AlunoDAO {
	public static List<Aluno> alunosList = new ArrayList<Aluno>();

	public void addAlunos() {
		alunosList.add(new Aluno("Vanessa", 1, "Analise e Desenvolvimento de Sistemas"));
	}

	public static AbstractPessoa getAluno(String nome) {
		for (Aluno aluno : alunosList) {
			if (nome.equalsIgnoreCase(aluno.getNome()))
				return new Aluno(aluno.getNome(), aluno.getCodigo(), aluno.getCurso());
		}
		return new PessoaNull();
	}
}
