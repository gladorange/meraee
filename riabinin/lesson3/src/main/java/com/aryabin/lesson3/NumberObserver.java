package com.aryabin.lesson3;

public class NumberObserver implements IObserver {

	private NumberWriter writer;
	
	public NumberObserver(String fileName) {
		writer = new NumberWriter(fileName);
	}
	
	@Override
	public void notify(int num1, int num2) {
		String string = Integer.toString(num1) + " " + Integer.toString(num2) + " ";
		writer.Write(string);
	}

}
