package com.edu.ifsc.library;

import com.edu.ifsc.library.entities.Bibliotecario;
import com.edu.ifsc.library.entities.Emprestimo;
import com.edu.ifsc.library.entities.Pessoa;

public interface Servico {
	
	public void produz();
	
	public void realizaEmprestimo(String nomePessoa, Bibliotecario nomeFuncionario, String nomeLivro, int diasEmprestimo,
			int escolhePessoa);

	public void devolverEmprestimo(Pessoa pessoa, Emprestimo emprestimo, int diasDePosse);
	
}
