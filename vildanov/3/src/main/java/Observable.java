/**
 * Created by svildan on 13.10.2016.
 */
public interface  Observable {
    void addObserver(Observer o);
    void notifyObservers();
    void setPositiveNumbers(int n, int m);
    void setNegativeNumbers(int n, int m);

}
