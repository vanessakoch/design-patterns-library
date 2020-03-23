package com.edu.ifsc.library.entities;

import com.edu.ifsc.library.Colaborador;
import com.edu.ifsc.library.Servico;

public class Professor extends Pessoa implements Colaborador {
	private Servico funcao;

	public Professor(String nome, int codigo, Servico funcao) {
		super(nome, codigo);
		this.funcao = funcao;
	}

	@Override
	protected double valorXeroxPorFolha() {
		return this.getQuantidadeFolha() * 0.04;
	}

	@Override
	protected double valorImpressaoPorFolha() {
		return this.getQuantidadeFolha() * 0.05;
	}

	@Override
	public String toString() {
		return "Professor(a) " + nome + ", funcao: " + getFuncao();
	}

	public void executaFuncao() {
        funcao.produz();
	}

	public void executaEmprestimo(String nomePessoa, Bibliotecario nomeFuncionario, String nomeLivro, int diasEmprestimo,
			int escolhePessoa) {
		funcao.realizaEmprestimo(nomePessoa, nomeFuncionario, nomeLivro, diasEmprestimo, escolhePessoa);
	}
	
	public void executaDevolucao(Pessoa pessoa, Emprestimo emprestimo, int diasDePosse) {
		funcao.devolverEmprestimo(pessoa, emprestimo, diasDePosse);
	}
	
	public void recebeServico(Servico funcao) {
		this.funcao = funcao;
	}

	public String getFuncao() {
		return "Professor";
	}

}
