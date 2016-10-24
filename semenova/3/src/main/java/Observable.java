/**
 * Created by ansemen on 29.09.2016.
 */
public class Observable {
    Observers observers = new Observers();

    public void addNewObserver(Observer ob) {
        observers.add(ob);
    }

    public void setNumbers(int n1, int n2) {
        observers.notifyObjectCreated(n1, n2);
    }
}
