import java.util.ArrayList;
import java.util.List;

/**
 * Created by svildan on 13.10.2016.
 */
public class DataModel implements Observable {

    private List<Observer> observers;
    private int n;
    private int m;

    public DataModel(){
        observers = new ArrayList<Observer>();
    }

    @Override
    public void addObserver(Observer o) {
        if(o != null)
        observers.add(o);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(n, m);
        }
    }

    @Override
    public void setPositiveNumbers(int n, int m) {

    }

    @Override
    public void setNegativeNumbers(int n, int m) {

    }

    public void setNumbers(int n, int m) {
        this.n = n;
        this.m = m;
        notifyObservers();
    }
}
