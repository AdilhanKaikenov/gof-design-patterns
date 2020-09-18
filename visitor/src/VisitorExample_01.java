public class VisitorExample_01 {
    public static void main(String[] args) {
        Animal dog = new Dog();
        dog.accept(new SoundVisitor());
        dog.accept(new EatVisitor());

        System.out.println("\n===============================================\n");

        Animal cat = new Cat();
        cat.accept(new SoundVisitor());
        cat.accept(new EatVisitor());
    }
}

interface Animal {
    void accept(AnimalVisitor animalVisitor);
}

interface AnimalVisitor {
    void action(Dog dog);
    void action(Cat dog);
}

class Dog implements Animal {
    @Override
    public void accept(AnimalVisitor animalVisitor) {
        animalVisitor.action(this);
    }
}

class Cat implements Animal {
    @Override
    public void accept(AnimalVisitor animalVisitor) {
        animalVisitor.action(this);
    }
}

class SoundVisitor implements AnimalVisitor {
    @Override
    public void action(final Dog dog) {
        System.out.println("Wof");
    }

    @Override
    public void action(final Cat dog) {
        System.out.println("Mao");
    }
}

class EatVisitor implements AnimalVisitor {
    @Override
    public void action(final Dog dog) {
        System.out.println("Eat meat");
    }

    @Override
    public void action(final Cat dog) {
        System.out.println("Eat fish");
    }
}