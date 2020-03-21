package com.edu.ifsc.library.dao;

import java.util.ArrayList;
import java.util.List;

import com.edu.ifsc.library.AbstractPessoa;
import com.edu.ifsc.library.entities.Funcionario;
import com.edu.ifsc.library.entities.PessoaNull;

public class FuncionarioDAO {
	public static List<Funcionario> funcionariosList = new ArrayList<Funcionario>();

	public void addFuncionarios() {
		funcionariosList.add(new Funcionario("Andreia", 2, "Bibliotecaria", "Responsável pelos emprestimos"));
	}

	public static AbstractPessoa getFuncionario(String nome) {
		for (Funcionario funcionario : funcionariosList) {
			if (nome.equalsIgnoreCase(funcionario.getNome()))
				return new Funcionario(funcionario.getNome(), funcionario.getCodigo(), funcionario.getSetor(),
						funcionario.getFuncao());
		}
		return new PessoaNull();
	}
}
