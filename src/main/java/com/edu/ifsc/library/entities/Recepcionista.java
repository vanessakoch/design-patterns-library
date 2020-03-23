package com.edu.ifsc.library.entities;

import com.edu.ifsc.library.Colaborador;
import com.edu.ifsc.library.Servico;

public class Recepcionista extends Pessoa implements Colaborador {
	private Servico funcao;

	public Recepcionista(String nome, int codigo, Servico funcao) {
		super(nome, codigo);
		this.funcao = funcao;
	}

	@Override
	protected double valorXeroxPorFolha() {
		return this.getQuantidadeFolha() * 0.08;
	}

	@Override
	protected double valorImpressaoPorFolha() {
		return this.getQuantidadeFolha() * 0.12;
	}

	@Override
	public String toString() {
		return "Recepcionista " + nome + ", funcao: " + getFuncao();
	}

	public void executaFuncao() {
		funcao.produz();
	}

	public void executaEmprestimo(String nomePessoa, Bibliotecario nomeFuncionario, String nomeLivro,
			int diasEmprestimo, int escolhePessoa) {
		System.out.println("Recepcionista não cadastra emprestimos!");
	}

	public void executaDevolucao(Pessoa pessoa, Emprestimo emprestimo, int diasDePosse) {
		funcao.devolverEmprestimo(pessoa, emprestimo, diasDePosse);
	}

	public void recebeServico(Servico funcao) {
		this.funcao = funcao;
	}

	public String getFuncao() {
		return "Responsável pelas devoluções";
	}

}
