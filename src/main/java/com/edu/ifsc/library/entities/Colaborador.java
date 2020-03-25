package com.edu.ifsc.library.entities;

public interface Colaborador {

	public void executaFuncao();

	public void emprestar(String nomePessoa, Colaborador colaborador, String nomeLivro, int diasEmprestimo,
			int escolhePessoa);

	public void devolver(Pessoa pessoa, Colaborador funcionario, String livro, int diasDePosse);

	public void recebeServico(Servico servico);

}
