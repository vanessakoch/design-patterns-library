package com.edu.ifsc.library.dao;

import java.util.ArrayList;
import java.util.List;

import com.edu.ifsc.library.AbstractPessoa;
import com.edu.ifsc.library.CadastraEmprestimos;
import com.edu.ifsc.library.entities.Bibliotecario;
import com.edu.ifsc.library.entities.Colaborador;
import com.edu.ifsc.library.entities.PessoaNull;
import com.edu.ifsc.library.entities.Servico;

public class BibliotecarioDAO {
	public static List<Bibliotecario> bibliotecariosList = new ArrayList<Bibliotecario>();

	public void addBibliotecarios() {
		Servico servicoEmprestimo = new CadastraEmprestimos();
		
		Colaborador bibliotecario1 = new Bibliotecario("Maria", 2,servicoEmprestimo);
		Colaborador bibliotecario2 = new Bibliotecario("Joao", 3,servicoEmprestimo);
		
		bibliotecariosList.add((Bibliotecario) bibliotecario1);
		bibliotecariosList.add((Bibliotecario) bibliotecario2);

	}

	public static AbstractPessoa getBibliotecario(String nome) {
		Servico servicoEmprestimo = new CadastraEmprestimos();

		for (Bibliotecario bibliotecario : bibliotecariosList) {
			if (nome.equalsIgnoreCase(bibliotecario.getNome()))
				return new Bibliotecario(bibliotecario.getNome(), bibliotecario.getCodigo(), servicoEmprestimo);
		}
		return new PessoaNull();
	}
}
