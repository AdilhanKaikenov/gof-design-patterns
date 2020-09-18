public class BridgeExample_02 {
    public static void main(String[] args) {
        Program [] programs = {
                new BankSystem(new JavaDeveloper()),
                new StockExchange(new CppDeveloper())
        };

        for (Program program : programs) {
            program.developProgram();
        }
    }
}

abstract class Program {

    protected Developer developer;

    protected Program(final Developer developer) {
        this.developer = developer;
    }

    public abstract void developProgram();
}

class BankSystem extends Program {

    protected BankSystem(final Developer developer) {
        super(developer);
    }

    @Override
    public void developProgram() {
        System.out.println("Bank system development in progress...");
        this.developer.writeCode();
    }
}

class StockExchange extends Program {

    protected StockExchange(final Developer developer) {
        super(developer);
    }

    @Override
    public void developProgram() {
        System.out.println("Stock Exchange development in progress...");
        this.developer.writeCode();
    }
}

interface Developer {
    void writeCode();
}

class JavaDeveloper implements Developer {

    @Override
    public void writeCode() {
        System.out.println("Java developer writes Java code...");
    }
}

class CppDeveloper implements Developer {

    @Override
    public void writeCode() {
        System.out.println("C++ developer writes C++ code...");
    }
}