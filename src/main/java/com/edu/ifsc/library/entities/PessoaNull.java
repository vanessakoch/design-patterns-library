package com.edu.ifsc.library.entities;

import com.edu.ifsc.library.AbstractPessoa;

public class PessoaNull extends AbstractPessoa{

	@Override
	public String getNome() {
		return "Essa pessoa não possui cadastro na biblioteca.";
	}

	@Override
	public Integer getCodigo() {
		return null;
	}
	
	@Override
	public String toString() {
		return getNome();
	}

}
