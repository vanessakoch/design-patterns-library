package com.edu.ifsc.library.dao;

import java.util.ArrayList;
import java.util.List;

import com.edu.ifsc.library.controller.DevolveEmprestimos;
import com.edu.ifsc.library.entities.AbstractPessoa;
import com.edu.ifsc.library.entities.Colaborador;
import com.edu.ifsc.library.entities.PessoaNull;
import com.edu.ifsc.library.entities.Recepcionista;
import com.edu.ifsc.library.entities.Servico;

public class RecepcionistaDAO {
	public static List<Recepcionista> recepcionistasList = new ArrayList<Recepcionista>();

	public void addRecepcionistas() {
		Servico servicoDevolucao = new DevolveEmprestimos();

		Colaborador recepcionista = new Recepcionista("Andreia", 6, servicoDevolucao);
		Colaborador recepcionista2 = new Recepcionista("Marilda", 7, servicoDevolucao);
		
		recepcionistasList.add((Recepcionista) recepcionista);
		recepcionistasList.add((Recepcionista) recepcionista2);


	}

	public static AbstractPessoa getRecepcionista(String nome) {
		Servico servicoDevolucao = new DevolveEmprestimos();

		for (Recepcionista recepcionista : recepcionistasList) {
			if (nome.equalsIgnoreCase(recepcionista.getNome()))
				return new Recepcionista(recepcionista.getNome(), recepcionista.getCodigo(),servicoDevolucao);
		}
		return new PessoaNull();
	}
}
