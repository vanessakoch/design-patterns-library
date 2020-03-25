package com.edu.ifsc.library.entities;

public class PessoaNull extends AbstractPessoa {

	@Override
	public String getNome() {
		return "Essa pessoa não possui cadastro na biblioteca.";
	}

	@Override
	public Integer getCodigo() {
		return 0;
	}

	@Override
	public String toString() {
		return getNome();
	}

}
