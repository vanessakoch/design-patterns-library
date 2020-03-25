package com.edu.ifsc.library.dao;

import java.util.ArrayList;
import java.util.List;

import com.edu.ifsc.library.controller.MinistrarAula;
import com.edu.ifsc.library.entities.AbstractPessoa;
import com.edu.ifsc.library.entities.PessoaNull;
import com.edu.ifsc.library.entities.Professor;
import com.edu.ifsc.library.entities.Servico;

public class ProfessorDAO {
	public static List<Professor> professoresList = new ArrayList<Professor>();

	public void addProfessores() {
		Servico ministrarAula = new MinistrarAula();
		Professor professor = new Professor("Lucas", 1, ministrarAula);
		Professor professor1 = new Professor("Mauricio", 2, ministrarAula);
		Professor professor2 = new Professor("Luciano", 3, ministrarAula);
		Professor professor3 = new Professor("Carlos", 4, ministrarAula);

		professoresList.add(professor);
		professoresList.add(professor1);
		professoresList.add(professor2);
		professoresList.add(professor3);
	}

	public static AbstractPessoa getProfessor(String nome) {
		Servico ministrarAula = new MinistrarAula();

		for (Professor professor : professoresList) {
			if (nome.equalsIgnoreCase(professor.getNome()))
				return new Professor(professor.getNome(), professor.getCodigo(), ministrarAula);
		}
		return new PessoaNull();
	}
}
