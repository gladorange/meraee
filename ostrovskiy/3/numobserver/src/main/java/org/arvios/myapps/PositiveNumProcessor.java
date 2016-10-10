package org.arvios.myapps;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by artem-ostrovsky on 10.10.2016.
 */
public class PositiveNumProcessor implements Observer {
    public void notify(int n1, int n2) throws IOException {
        if (n1 > 0 && n2 > 0) {
            try (PrintWriter pout = new PrintWriter(new FileWriter("F:\\JavaEEbasic\\03\\positiveNumbers.txt"))) {
                pout.println(Integer.toString(n1));
                pout.println(Integer.toString(n2));
            }
        }
    }
}
