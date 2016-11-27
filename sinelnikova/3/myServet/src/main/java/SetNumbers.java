import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Viktoria on 28-Sep-16.
 */
public class SetNumbers implements Observable {
    ArrayList<Observer> arr = new ArrayList<>(Arrays.asList(new ObservPositive(), new ObservNegative()));

    public void setNumbers(int a, int b) {
        for (Observer observer : arr) {
            observer.notifyNum(a, b);
        }
    }
}
