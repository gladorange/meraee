package com.sersmir.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sersmir on 09.12.2016.
 */
public class ObservableImpl implements Observable {
    private List<Observer> observers = new ArrayList<Observer>();

    public void setNumbers(int n1, int n2) {
        for (Observer obs : observers) {
            obs.notify(n1, n2);
        }
    }

    public void registerObserver(Observer o) {
        if (o != null) {
            observers.add(o);
        }
    }

    public void removeObserver(Observer o) {
        if (o != null) {
            observers.remove(o);
        }
    }
}
