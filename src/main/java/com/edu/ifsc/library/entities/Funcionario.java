package com.edu.ifsc.library.entities;

import java.util.ArrayList;
import java.util.List;

public class Funcionario extends Pessoa {
	private String setor;
	private String funcao;
	private List<Emprestimo> emprestimosRealizados = new ArrayList<Emprestimo>();

	public Funcionario(String nome, int codigo, String setor, String funcao) {
		super(nome, codigo);
		this.setor = setor;
		this.funcao = funcao;
	}

	public Emprestimo getEmprestimo(String nomeLivro) {
		for (Emprestimo livro : emprestimosRealizados) {
			if (livro.getLivro().getNomeLivro().contentEquals(nomeLivro)) {
				return livro;
			}
		}
		return null;
	}
	
	@Override
	public List<Emprestimo> getEmprestimosRealizados() {
		return emprestimosRealizados;
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
