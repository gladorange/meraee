package com.seprokof.eebasic.impl;

import java.util.ArrayList;
import java.util.List;

import com.seprokof.eebasic.Observable;
import com.seprokof.eebasic.Observer;

public class ObservableImpl implements Observable {
	private final List<Observer> subscribers = new ArrayList<>();

	@Override
	public void registerObserver(Observer o) {
		subscribers.add(o);
	}

	@Override
	public void removeObserver(Observer o) {
		subscribers.remove(0);
	}

	@Override
	public void notify(int first, int second) {
		subscribers.stream().forEach(s -> s.setNumbers(first, second));
	}

}
