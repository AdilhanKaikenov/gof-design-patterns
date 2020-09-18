public class TemplateExample_01 {
    public static void main(String[] args) {

        Beverage coffee = new Coffee();
        Beverage tea = new Tea();

        coffee.makeBeverage();
        tea.makeBeverage();
    }
}

abstract class Beverage {
    private void boilWater() {
        System.out.println("Boiled water");
    }

    private void addSugar() {
        System.out.println("Add sugar");
    }

    public void hook() {

    }

    abstract void addBeverage();
    abstract void addCondiment();

    public void makeBeverage() {
        this.boilWater();
        this.addBeverage();
        this.addSugar();
        this.addCondiment();
        this.hook();
    }
}

class Coffee extends Beverage {

    @Override
    void addBeverage() {
        System.out.println("Add coffee");
    }

    @Override
    void addCondiment() {
        System.out.println("Add milk");
    }

    @Override
    public void hook() {
        System.out.println("Add syrup");
    }
}

class Tea extends Beverage{

    @Override
    void addBeverage() {
        System.out.println("Add tea");
    }

    @Override
    void addCondiment() {
        System.out.println("Add lemon");
    }
}
