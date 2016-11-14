package com.aryabin.lesson3;

public class NegativeNumberObserver extends NumberObserver {

	public NegativeNumberObserver() {
		super("negativeNumbers");
	}

	@Override
	public void notify(int num1, int num2) {
		if (num1 < 0 && num2 < 0) {
			super.notify(num1, num2);
		}
	}
}
