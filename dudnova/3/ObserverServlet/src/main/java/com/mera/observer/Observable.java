package com.mera.observer;

public interface Observable {
	void setNumbers(int n1, int n2);
	void addObserver(Observer observer);
}
