package com.edu.ifsc.library.entities;

public interface Servico {
	
	public void produz();
	
	public void realizaEmprestimo(String nomePessoa, Bibliotecario nomeFuncionario, String nomeLivro, int diasEmprestimo,
			int escolhePessoa);

	public void devolverEmprestimo(Pessoa pessoa, Recepcionista funcionario, String livro, int diasDePosse);
	
	
	
}
