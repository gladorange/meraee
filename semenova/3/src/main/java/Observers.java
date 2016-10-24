import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by ansemen on 29.09.2016.
 */
public class Observers<T extends Observer> extends ArrayList<T> {

    public void notifyObjectCreated(int n1, int n2) {
        for (Iterator<T> iter = iterator(); iter.hasNext();) {
            iter.next().notify(n1, n2);
        }
    }
}
