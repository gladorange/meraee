package com.sersmir.observer;
/**
 * Created by sersmir on 09.12.2016.
 */
public interface Observable {
    void setNumbers(int n1, int n2);
    void registerObserver(Observer o);
    void removeObserver(Observer o);

}
