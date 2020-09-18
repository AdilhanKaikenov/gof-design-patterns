
public class StrategyExample_01 {
    public static void main(String[] args) {
        Car toyota = new Toyota(new FlyCar());
        Car tractor = new Tractor(new NoFlyCar());

        toyota.fly();
        tractor.fly();
    }
}

interface Flyable {
    void fly();
}

class FlyCar implements Flyable {
    @Override
    public void fly() {
        System.out.println("Fly");
    }
}

class NoFlyCar implements Flyable {
    @Override
    public void fly() {
        System.out.println("No Fly");
    }
}

abstract class Car {

    private Flyable flyable;

    public Car(final Flyable flyable) {
        this.flyable = flyable;
    }

    public void stop() {
        System.out.println("Stop car");
    }

    public void fly() {
        this.flyable.fly();
    }

    abstract void run();
}

class Toyota extends Car {

    public Toyota(final Flyable flyable) {
        super(flyable);
    }

    @Override
    void run() {
        System.out.println("Run Toyota");
    }
}

class Nissan extends Car {

    public Nissan(final Flyable flyable) {
        super(flyable);
    }

    @Override
    void run() {
        System.out.println("Run Nissan");
    }
}

class Tractor extends Car {

    public Tractor(final Flyable flyable) {
        super(flyable);
    }

    @Override
    void run() {
        System.out.println("Run Tractor");
    }
}