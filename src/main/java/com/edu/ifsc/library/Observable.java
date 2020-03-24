package com.edu.ifsc.library;

public interface Observable {
	
	public void registraObserver(Observer observer);

	public void removeObserver(Observer observer);

	public void notifyObserver(String message);
	
}
