package com.edu.ifsc.library.entities;


public abstract class AbstractPessoa {
	protected String nome;
	protected Integer codigo;

	
	public abstract String getNome();
	public abstract Integer getCodigo();
}
