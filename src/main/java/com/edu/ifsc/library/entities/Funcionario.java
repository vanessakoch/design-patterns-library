package com.edu.ifsc.library.entities;

public class Funcionario extends Pessoa {
	private String setor;
	private String funcao;

	public Funcionario(String nome, int codigo, String setor, String funcao) {
		super(nome, codigo);
		this.setor = setor;
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
	
	public String getSetor() {
		return setor;
	}

	public void setSetor(String setor) {
		this.setor = setor;
	}

	public String getFuncao() {
		return funcao;
	}

	public void setFuncao(String funcao) {
		this.funcao = funcao;
	}

	@Override
	public String toString() {
		return "Funcionario(a) " + nome + ", setor: " + setor + ", funcao: " + funcao;
	}

}
