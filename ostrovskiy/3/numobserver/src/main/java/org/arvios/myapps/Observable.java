package org.arvios.myapps;

import java.io.IOException;

/**
 * Created by artem-ostrovsky on 10.10.2016.
 */
public interface Observable {
    void addObserver(Observer obs);
    void removeObserver(Observer obs);
    void setNumbers(int n1, int n2) throws IOException;
}
