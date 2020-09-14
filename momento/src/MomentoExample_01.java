import java.util.ArrayList;
import java.util.List;

/**
 * Wikipedia says
 *
 * The memento pattern is a software design pattern that provides the ability to restore an object to its previous state (undo via rollback).
 *
 * We can have an object in some state and we can change this state. Momento is used if over time we may need to return to a previous state.
 */
public class MomentoExample_01 {
    public static void main(String[] args) {
        List<Originator.Momento> states = new ArrayList<>();

        Originator originator = new Originator();
        originator.setState("One");
        states.add(originator.saveState());
        originator.setState("Two");
        states.add(originator.saveState());
        originator.setState("Three");

        System.out.println(originator.getState());

        // restore
        originator.restoreFromMomento(states.get(0));
        System.out.println(originator.getState());

    }
}

class Originator {

    private String state;

    public void setState(final String state) {
        this.state = state;
    }

    public String getState() {
        return this.state;
    }

    public Originator.Momento saveState() {
        return new Momento(this.state);
    }

    public void restoreFromMomento(Momento momento) {
        this.state = momento.state;
    }

    static class Momento {
        private String state;

        public Momento(final String state) {
            this.state = state;
        }

        public String getState() {
            return this.state;
        }
    }

}