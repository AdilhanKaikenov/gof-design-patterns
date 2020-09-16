import java.util.Random;

/**
 * The idea is that we have an abstract class State and it has methods that allow you to move from one state to another,
 * and a separate implementation will be responsible for each state, and as a parameter it receives an object that has this state,
 * where we change it
 */
public class StateExample_01 {
    public static void main(String[] args) {
        GumMachine gumMachine = new GumMachine();

        gumMachine.insertQuarter();
        gumMachine.insertQuarter();
        gumMachine.turnCrank();

    }
}

// Состояние аппарата жевательной резинки
abstract class State {
    protected int count = 10;

    abstract public void insertQuarter(GumMachine gumMachine); // вставить четверть

    abstract public void turnCrank(GumMachine gumMachine); // повернуть рукоятку
}

class GumMachine {
    private State state = new NoQuarter();

    public State getState() {
        return this.state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public void insertQuarter() {
        this.state.insertQuarter(this);
    }

    public void turnCrank() {
        this.state.turnCrank(this);
    }
}

class SoldOut extends State {

    @Override
    public void insertQuarter(GumMachine gumMachine) {
        System.out.println("No gums");
    }

    @Override
    public void turnCrank(GumMachine gumMachine) {
        System.out.println("No gums");
    }
}

class HasQuarter extends State {
    @Override
    public void insertQuarter(GumMachine gumMachine) {
        System.out.println("You have set quarter already");
    }

    @Override
    public void turnCrank(GumMachine gumMachine) {
        if (this.count <= 0) {
            gumMachine.setState(new SoldOut());
        } else {
            System.out.println("Selling...");
            this.count--;
            gumMachine.setState(new NoQuarter());
        }
    }
}

class NoQuarter extends State {

    @Override
    public void insertQuarter(GumMachine gumMachine) {
        if (new Random().nextBoolean()) {
            gumMachine.setState(new Winner());
        } else {
            gumMachine.setState(new HasQuarter());
        }
    }

    @Override
    public void turnCrank(GumMachine gumMachine) {
        System.out.println("No Quarter");
    }
}

class Winner extends State {

    @Override
    public void insertQuarter(GumMachine gumMachine) {
        System.out.println("You are winner!");
    }

    @Override
    public void turnCrank(GumMachine gumMachine) {
        System.out.println("Get Gum");
        gumMachine.setState(new NoQuarter());
    }
}