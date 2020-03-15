package com.edu.ifsc.library;

public class Funcionario extends Pessoa {
	private String setor;
	private String funcao;

	public Funcionario(String nome, String cpf, int codigo, String setor, String funcao) {
		super(nome, cpf, codigo);
		this.setor = setor;
		this.funcao = funcao;
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

}
