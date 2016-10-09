package com.observer;

import java.util.ArrayList;
import java.util.List;

public class Data implements Observable{
	
	private List<Observer> observers;
	private int n1;	
	private int n2;
		
	public Data() {
		observers = new ArrayList<Observer>();
	}

	@Override
	public void notifyObservers() {
        for (Observer observer : observers)
            observer.update(n1, n2);		
	}

	@Override
	public void registerObserver(Observer o) {
		observers.add(o);		
	}

	@Override
	public void removeObserver(Observer o) {
		observers.remove(o);
	}	
	
    public void setNumbers(int n1, int n2) {
        this.n1 = n1;
        this.n2 = n2;
        notifyObservers();
    }
}
