package com.edu.ifsc.library.controller;

import com.edu.ifsc.library.entities.Bibliotecario;
import com.edu.ifsc.library.entities.Colaborador;
import com.edu.ifsc.library.entities.Pessoa;
import com.edu.ifsc.library.entities.Recepcionista;
import com.edu.ifsc.library.entities.Servico;

public class MinistrarAula implements Servico {

	public void produz() {
		System.out.println("Trabalha como professor");
	}

	public void realizaEmprestimo(String nomePessoa, Colaborador nomeFuncionario, String nomeLivro,
			int diasEmprestimo, int escolhePessoa) {
		System.out.println("Nao realizo emprestimos, apenas dou aulas!");
	}

	public void devolverEmprestimo(Pessoa pessoa, Colaborador funcionario, String livro, int diasDePosse) {
		System.out.println("Nao devolvo emprestimos, apenas dou aulas!");
	}

	@Override
	public String toString() {
		return "Professor";
	}
	
	

}
