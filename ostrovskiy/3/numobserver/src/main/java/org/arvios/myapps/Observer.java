package org.arvios.myapps;

import java.io.IOException;

/**
 * Created by artem-ostrovsky on 10.10.2016.
 */
public interface Observer {
    void notify(int n1, int n2) throws IOException;
}
