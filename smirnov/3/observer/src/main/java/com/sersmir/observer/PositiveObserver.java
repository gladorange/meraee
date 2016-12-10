package com.sersmir.observer;

/**
 * Created by sersmir on 09.12.2016.
 */
public class PositiveObserver implements Observer {
    private static final String FILENAME = "c:\\TEMP\\positive_numbers.txt";

    public void notify(int n1, int n2) {
        if (n1 > 0 && n2 > 0) {
            writeToFile(FILENAME, n1 + " " + n2 + "\n");
        }
    }
}
