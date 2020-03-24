package com.edu.ifsc.library.entities;

public interface Colaborador {

	public void executaFuncao();
	
	public void emprestar(String nomePessoa, Bibliotecario nomeFuncionario, String nomeLivro, int diasEmprestimo,
			int escolhePessoa);

	public void devolver(Pessoa pessoa, Recepcionista funcionario, String livro, int diasDePosse);

	public void recebeServico(Servico servico);
	
	

}
