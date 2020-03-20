package com.edu.ifsc.library;

import java.util.List;

import com.edu.ifsc.library.entities.Emprestimo;

public abstract class AbstractPessoa {
	protected String nome;
	protected Integer codigo;
	protected List<Emprestimo> emprestimosRealizados;
	
	public abstract String getNome();
	public abstract Integer getCodigo();
	public abstract List<Emprestimo> getEmprestimosRealizados();
}
