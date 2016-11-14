package com.aryabin.lesson3;

public class PositiveNumberObserver extends NumberObserver {

	public PositiveNumberObserver() {
		super("positiveNumbers");
	}

	@Override
	public void notify(int num1, int num2) {
		if (num1 > 0 && num2 > 0) {
			super.notify(num1, num2);
		}
	}
}
