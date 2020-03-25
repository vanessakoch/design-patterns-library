package com.edu.ifsc.library.entities;

public interface Servico {
	
	public void produz();
	
	public void realizaEmprestimo(String nomePessoa, Colaborador nomeFuncionario, String nomeLivro, int diasEmprestimo,
			int escolhePessoa);

	public void devolverEmprestimo(Pessoa pessoa, Colaborador funcionario, String livro, int diasDePosse);
	
	
	
}
