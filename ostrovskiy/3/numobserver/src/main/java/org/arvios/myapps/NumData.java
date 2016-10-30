package org.arvios.myapps;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by artem-ostrovsky on 10.10.2016.
 */
public class NumData implements Observable {
    private List<Observer> observers;

    public NumData() {
        observers = new ArrayList<Observer>();
    }

    public void addObserver(Observer obs) {
        observers.add(obs);
    }

    public void removeObserver(Observer obs) {
        observers.remove(obs);
    }

    public void setNumbers(int n1, int n2) throws IOException {
        for (Observer obs : observers) {
            obs.notify(n1, n2);
        }
    }
}
