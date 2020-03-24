package com.edu.ifsc.library.dao;

import java.util.ArrayList;
import java.util.List;
import com.edu.ifsc.library.AbstractPessoa;
import com.edu.ifsc.library.AlunoMatriculado;
import com.edu.ifsc.library.AlunoState;
import com.edu.ifsc.library.entities.Aluno;

import com.edu.ifsc.library.entities.PessoaNull;

public class AlunoDAO {
	public static List<Aluno> alunosList = new ArrayList<Aluno>();

	public void addAlunos() {
		AlunoState startState = new AlunoMatriculado();

		alunosList.add(new Aluno("Vanessa", 1, "Analise e Desenvolvimento de Sistemas"));
		alunosList.add(new Aluno("Felipe", 2, "Analise e Desenvolvimento de Sistemas"));
		alunosList.add(new Aluno("Ramon", 3, "Analise e Desenvolvimento de Sistemas"));
		alunosList.add(new Aluno("Leonardo", 4, "Analise e Desenvolvimento de Sistemas"));
		alunosList.add(new Aluno("Rojie", 5, "Analise e Desenvolvimento de Sistemas"));
		alunosList.add(new Aluno("Fernando", 6, "Analise e Desenvolvimento de Sistemas"));

		for (Aluno aluno : alunosList) {
			aluno.setEstado(startState);
		}

	}

	public static AbstractPessoa getAluno(String nome) {
		for (Aluno aluno : alunosList) {
			if (nome.equalsIgnoreCase(aluno.getNome()))
				return new Aluno(aluno.getNome(), aluno.getCodigo(), aluno.getCurso());
		}
		return new PessoaNull();
	}
}
