package com.edu.ifsc.library.entities;

import com.edu.ifsc.library.AbstractPessoa;

public class Recepcionista extends Pessoa implements Colaborador {
	private Servico funcao;

	public Recepcionista(String nome, int codigo, Servico funcao) {
		super(nome, codigo);
		this.funcao = funcao;
	}

	@Override
	protected double valorXeroxPorFolha() {
		return this.getQuantidadeFolha() * 0.03;
	}

	@Override
	protected double valorImpressaoPorFolha() {
		return this.getQuantidadeFolha() * 0.4;
	}

	@Override
	public String toString() {
		return "Recepcionista " + nome + ", funcao: " + getFuncao();
	}

	public void executaFuncao() {
		funcao.produz();
	}

	public void emprestar(String nomePessoa, Bibliotecario nomeFuncionario, String nomeLivro, int diasEmprestimo,
			int escolhePessoa) {
		funcao.realizaEmprestimo(nomePessoa, nomeFuncionario, nomeLivro, diasEmprestimo, escolhePessoa);
	}

	public void devolver(Pessoa pessoa, Recepcionista funcionario, String livro, int diasDePosse) {
		funcao.devolverEmprestimo(pessoa, funcionario, livro, diasDePosse);
	}

	public void recebeServico(Servico funcao) {
		this.funcao = funcao;
	}

	public Servico getFuncao() {
		return funcao;
	}

}
