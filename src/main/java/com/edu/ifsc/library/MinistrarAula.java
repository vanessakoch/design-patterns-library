package com.edu.ifsc.library;

import com.edu.ifsc.library.entities.Bibliotecario;
import com.edu.ifsc.library.entities.Pessoa;
import com.edu.ifsc.library.entities.Recepcionista;
import com.edu.ifsc.library.entities.Servico;

public class MinistrarAula implements Servico {

	public void produz() {
		System.out.println("Trabalha como professor");
	}

	public void realizaEmprestimo(String nomePessoa, Bibliotecario nomeFuncionario, String nomeLivro,
			int diasEmprestimo, int escolhePessoa) {
		System.out.println("Nao realizo emprestimos, apenas dou aulas!");
	}

	public void devolverEmprestimo(Pessoa pessoa, Recepcionista funcionario, String livro, int diasDePosse) {
		System.out.println("Nao devolvo emprestimos, apenas dou aulas!");
	}

	@Override
	public String toString() {
		return "Professor";
	}
	
	

}
