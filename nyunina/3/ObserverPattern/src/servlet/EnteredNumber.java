package servlet;

import java.util.ArrayList;

public class EnteredNumber implements Observable{

	private ArrayList<Observer> observers = new ArrayList<Observer>();
	Integer number1, number2;
	
	public void setNumbers(Integer number1, Integer number2) {
		this.number1= number1;
		this.number2 = number2;
		notifyObservers();
	}
	
	public void addObserver(Observer o) {
		observers.add(o);
	}

	public void deleteObserver(Observer o) {
		observers.remove(o);
	}

	public void notifyObservers() {

		for (Observer o : observers) {
            
            o.update(number1,number2);
     }
		
	}


}
