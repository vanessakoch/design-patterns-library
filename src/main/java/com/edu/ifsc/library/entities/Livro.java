package com.edu.ifsc.library.entities;

public class Livro extends AbstractLivro {
	private String nomeLivro;
	private String autor;
	private int edicao;
	private int ano;
	private int quantidade;
	private LivroState livroState;
	private LivroEstante startState = new LivroEstante();
    
	public Livro(String nomeLivro, int edicao, String autor, int ano) {
		super();
		this.nomeLivro = nomeLivro;
		this.edicao = edicao;
		this.autor = autor;
		this.ano = ano;
		this.quantidade = 1;
		this.livroState = startState;
	}
	
	 public void setState(LivroState state){
	      this.livroState = state;		
	   }

	   public LivroState getState(){
	      return livroState;
	   }

	@Override
	public String getNomeLivro() {
		return nomeLivro;
	}

	@Override
	public String getAutorLivro() {
		return autor;
	}

	@Override
	public Integer getAnoLivro() {
		return ano;
	}

	public int getEdicao() {
		return edicao;
	}

	public void setEdicao(int edicao) {
		this.edicao = edicao;
	}

	@Override
	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	@Override
	public String toString() {
		return "Livro " + nomeLivro + ", autor: " + autor + ", ano: " + ano + ", estado: " + livroState.imprimirState();
	}

}
