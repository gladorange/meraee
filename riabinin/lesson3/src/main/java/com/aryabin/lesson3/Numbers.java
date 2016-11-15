package com.aryabin.lesson3;

import java.util.ArrayList;
import java.util.List;

public class Numbers implements IObservable {

	private List<IObserver> observers;
	
	public Numbers() {
		observers = new ArrayList<IObserver>();
	}
	
	@Override
	public void addObserver(IObserver observer) {
		if (!observers.contains(observer)) {
			observers.add(observer);
		}
	}

	@Override
	public void removeObserver(IObserver observer) {
		if (observers.contains(observer)) {
			observers.remove(observer);
		}
	}

	@Override
	public void setNumbers(int num1, int num2) {
		for(IObserver observer : observers) {
			observer.notify(num1, num2);
		}
	}

}
