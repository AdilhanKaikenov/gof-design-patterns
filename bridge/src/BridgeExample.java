/**
 * When adding a new vehicle or model, you don't have to add new implementation classes.
 *
 * Wikipedia says
 *
 * The bridge pattern is a design pattern used in software engineering that is meant to
 * "decouple an abstraction from its implementation so that the two can vary independently"
 */
public class BridgeExample {
    public static void main(String[] args) {

        Vehicle vehicle1 = new Car(new Toyota());
        vehicle1.drive();

        Vehicle vehicle2 = new Track(new Audi());
        vehicle2.drive();
    }
}

// Транспортное средство
abstract class Vehicle {

    Model model;

    public Vehicle(final Model model) {
        this.model = model;
    }

    abstract void drive();
}

class Car extends Vehicle {

    public Car(final Model model) {
        super(model);
    }

    @Override
    void drive() {
        this.model.drive("Drive car");
    }
}

class Track extends Vehicle {

    public Track(final Model model) {
        super(model);
    }

    @Override
    void drive() {
        this.model.drive("Drive track");
    }
}

// The interface which is the vehicle model
interface Model {
    void drive(String str);
}

class Audi implements Model {

    @Override
    public void drive(final String str) {
        System.out.println(str + " (Audi)");
    }
}

class Toyota implements Model {

    @Override
    public void drive(final String str) {
        System.out.println(str + " (Toyota)");
    }
}
