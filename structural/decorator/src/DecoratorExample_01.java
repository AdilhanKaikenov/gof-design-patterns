/**
 * Decorator design pattern is used to modify the functionality of an object at runtime.
 */
public class DecoratorExample_01 {
    public static void main(String[] args) {
        final CheesePizza cheesePizza = new CheesePizza(new DoughPizza());
        final PeperoniPizza peperoniPizza = new PeperoniPizza(cheesePizza);
        System.out.println(peperoniPizza.makePizza());
    }
}

interface Pizza {
    String makePizza();
}

class DoughPizza implements Pizza {

    @Override
    public String makePizza() {
        return "with";
    }
}

class CheesePizza implements Pizza {

    private Pizza pizza;

    public CheesePizza(final Pizza pizza) {
        this.pizza = pizza;
    }

    @Override
    public String makePizza() {
        return this.pizza.makePizza() + " cheese";
    }
}

class PeperoniPizza implements Pizza {

    private Pizza pizza;

    public PeperoniPizza(final Pizza pizza) {
        this.pizza = pizza;
    }

    @Override
    public String makePizza() {
        return this.pizza.makePizza() + " peperoni";
    }
}