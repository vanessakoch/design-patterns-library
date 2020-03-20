package com.edu.ifsc.library.entities;

import com.edu.ifsc.library.AbstractPessoa;

public abstract class Pessoa extends AbstractPessoa {
	protected String nome;
	private int codigo;

	public Pessoa(String nome, int codigo) {
		super();
		this.nome = nome;
		this.codigo = codigo;
	}

	@Override
	public String getNome() {
		return nome;
	}

	@Override
	public Integer getCodigo() {
		return codigo;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@Override
	public String toString() {
		return nome + ", código: " + codigo;
	}

}
