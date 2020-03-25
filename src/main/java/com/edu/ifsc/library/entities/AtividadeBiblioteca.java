package com.edu.ifsc.library.entities;

import java.util.ArrayList;
import java.util.List;

import com.edu.ifsc.library.controller.Observable;
import com.edu.ifsc.library.controller.Observer;

public class AtividadeBiblioteca implements Observable {
	private String nome;
	private List<Observer> canaisComunicacao;

	public AtividadeBiblioteca(String nome) {
		this.nome = nome;
	}

	public void registraObserver(Observer observer) {
		getObservers().add(observer);
	}

	public void removeObserver(Observer observer) {
		getObservers().remove(observer);
	}

	public String getName() {
		return nome;
	}

	public void setName(String name) {
		this.nome = name;
	}
	
	private List<Observer> getObservers() {
		if (canaisComunicacao == null)
			this.canaisComunicacao = new ArrayList<Observer>();
		return canaisComunicacao;
	}

	@Override
	public String toString() {
		return nome;
	}

	public void notifyObserver(String message) {
		for (Observer observ : canaisComunicacao)
			observ.update(this, message);
	}

}
