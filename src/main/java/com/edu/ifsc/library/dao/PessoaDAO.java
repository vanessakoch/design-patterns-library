package com.edu.ifsc.library.dao;

import java.util.ArrayList;
import java.util.List;

import com.edu.ifsc.library.controller.CadastraEmprestimos;
import com.edu.ifsc.library.controller.DevolveEmprestimos;
import com.edu.ifsc.library.controller.MinistrarAula;
import com.edu.ifsc.library.entities.AbstractPessoa;
import com.edu.ifsc.library.entities.Aluno;
import com.edu.ifsc.library.entities.Bibliotecario;
import com.edu.ifsc.library.entities.PessoaNull;
import com.edu.ifsc.library.entities.Professor;
import com.edu.ifsc.library.entities.Recepcionista;
import com.edu.ifsc.library.entities.Servico;

public class PessoaDAO {

	public static AbstractPessoa getPessoa(String nome) {
		Servico ministrarAula = new MinistrarAula();
		Servico servicoDevolucao = new DevolveEmprestimos();
		Servico servicoEmprestimo = new CadastraEmprestimos();

		for (Aluno aluno : AlunoDAO.alunosList) {
			for (Professor prof : ProfessorDAO.professoresList) {
				for (Recepcionista recep : RecepcionistaDAO.recepcionistasList) {
					for (Bibliotecario bib : BibliotecarioDAO.bibliotecariosList) {
						if (nome.equalsIgnoreCase(aluno.getNome()))
							return new Aluno(aluno.getNome(), aluno.getCodigo(), aluno.getCurso());
						if (nome.equalsIgnoreCase(prof.getNome()))
							return new Professor(prof.getNome(), prof.getCodigo(), ministrarAula);
						if (nome.equalsIgnoreCase(recep.getNome()))
							return new Recepcionista(recep.getNome(), recep.getCodigo(), servicoDevolucao);
						if (nome.equalsIgnoreCase(bib.getNome()))
							return new Bibliotecario(bib.getNome(), bib.getCodigo(), servicoEmprestimo);
					}
				}
			}
		}
		return new PessoaNull();
	}
}
