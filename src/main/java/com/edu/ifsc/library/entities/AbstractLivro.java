package com.edu.ifsc.library.entities;

public abstract class AbstractLivro {
	protected String nomeLivro;
	protected String autor;
	protected Integer ano;
	protected Integer quantidade;
	
	public abstract String getNomeLivro();
	public abstract String getAutorLivro();
	public abstract Integer getAnoLivro();
	public abstract Integer getQuantidade();

}
