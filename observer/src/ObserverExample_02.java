import java.util.Observable;
import java.util.Observer;

/**
 * Wikipedia says
 *
 * The observer pattern is a software design pattern in which an object, called the subject, maintains a list of its dependents,
 * called observers, and notifies them automatically of any state changes, usually by calling one of their methods.
 */
public class ObserverExample_02 {
    public static void main(String[] args) {

        Subject2 subject2 = new Subject2();
        subject2.addObserver(new Subscriber3());
        subject2.addObserver(new Subscriber4());
        subject2.setChanged();

        subject2.notifyObservers("Hello!");
    }
}

class Subject2 extends Observable {
    @Override
    protected synchronized void setChanged() {
        super.setChanged();
    }
}

class Subscriber3 implements Observer {

    @Override
    public void update(Observable o, Object arg) {
        System.out.println("Subscriber3: " + arg);
    }
}

class Subscriber4 implements Observer {

    @Override
    public void update(Observable o, Object arg) {
        System.out.println("Subscriber4: " + arg);
    }
}