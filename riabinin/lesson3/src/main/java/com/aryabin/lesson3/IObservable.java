package com.aryabin.lesson3;

public interface IObservable {
	public void addObserver(IObserver observer);
	public void removeObserver(IObserver observer);
	public void setNumbers(int num1, int num2);
}
