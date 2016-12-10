package com.sersmir.observer;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by sersmir on 09.12.2016.
 */
public interface Observer {
    void notify(int n1, int n2);

    default void writeToFile(String filename, String textToWrite) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filename, true))) {
            bw.write(textToWrite);
        } catch (IOException ex) {
            ex.getStackTrace();
        }

    }
}
