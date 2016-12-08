package com.mera.observer;

import java.util.ArrayList;
import java.util.List;

public class ObservableList implements Observable{
	private List<Observer> observerList;
	
	public ObservableList() {
		observerList = new ArrayList<Observer>();
	}

	@Override
	public void setNumbers(int n1, int n2) {
		// TODO Auto-generated method stub
		for (Observer observer : observerList) {
			observer.notify(n1, n2);
		}
	}

	@Override
	public void addObserver(Observer observer) {
		// TODO Auto-generated method stub
		observerList.add(observer);
		
	}

}
