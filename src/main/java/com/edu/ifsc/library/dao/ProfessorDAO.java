package com.edu.ifsc.library.dao;

import java.util.ArrayList;
import java.util.List;

import com.edu.ifsc.library.AbstractPessoa;
import com.edu.ifsc.library.Colaborador;
import com.edu.ifsc.library.MinistrarAula;
import com.edu.ifsc.library.Servico;
import com.edu.ifsc.library.entities.PessoaNull;
import com.edu.ifsc.library.entities.Professor;

public class ProfessorDAO {
	public static List<Professor> professoresList = new ArrayList<Professor>();

	public void addProfessores() {
		Servico ministrarAula = new MinistrarAula();
		Colaborador professor = new Professor("Jose", 5, ministrarAula);
		professoresList.add((Professor) professor);
	}

	public static AbstractPessoa getBibliotecario(String nome) {
		Servico ministrarAula = new MinistrarAula();

		for (Professor professor : professoresList) {
			if (nome.equalsIgnoreCase(professor.getNome()))
				return new Professor(professor.getNome(), professor.getCodigo(), ministrarAula);
		}
		return new PessoaNull();
	}
}
