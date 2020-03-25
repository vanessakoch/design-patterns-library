package com.edu.ifsc.library.entities;

import com.edu.ifsc.library.controller.Observable;
import com.edu.ifsc.library.controller.Observer;

public class Dispositivo implements Observer {
	private String name;

	public Dispositivo(String name) {
		super();
		this.name = name;
	}

	public void update(Observable observable, String message) {
		System.out.println(name + " - Atenção, notificação dada pelo(a) " + observable + ": " + message);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Dispositivo: " + name;
	}

}
