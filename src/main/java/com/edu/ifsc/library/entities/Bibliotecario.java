package com.edu.ifsc.library.entities;

import com.edu.ifsc.library.Colaborador;
import com.edu.ifsc.library.Servico;

public class Bibliotecario extends Pessoa implements Colaborador {
    private Servico funcao;

	public Bibliotecario(String nome, int codigo, Servico funcao) {
		super(nome, codigo);
		this.funcao = funcao;
	}

	@Override
	protected double valorXeroxPorFolha() {
		return this.getQuantidadeFolha() * 0.01;
	}

	@Override
	protected double valorImpressaoPorFolha() {
		return this.getQuantidadeFolha() * 0.03;
	}

	@Override
	public String toString() {
		return "Bibliotecario(a) " + nome + ", funcao: " + getFuncao();
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
		return "Responsável pelos emprestimos";
	}


}
