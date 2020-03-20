package com.edu.ifsc.library;

import com.edu.ifsc.library.entities.Emprestimo;

public interface InterfaceCalculoDevolucao {
	
	public double calcular(Emprestimo emprestimo, int diasPosse);
	
}
