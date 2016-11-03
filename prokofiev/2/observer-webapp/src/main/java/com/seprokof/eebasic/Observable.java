package com.seprokof.eebasic;

public interface Observable {
	void registerObserver(Observer o);
    void removeObserver(Observer o);
	void notify(int first, int second);
}
