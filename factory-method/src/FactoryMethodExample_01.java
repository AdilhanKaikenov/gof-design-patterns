/**
 * Wikipedia says
 *
 * In class-based programming, the factory method pattern is a creational pattern that uses factory methods to deal with the problem of
 * creating objects without having to specify the exact class of the object that will be created. This is done by creating objects
 * by calling a factory method — either specified in an interface and implemented by child classes, or implemented in a base class
 * and optionally overridden by derived classes—rather than by calling a constructor.
 */
public class FactoryMethodExample_01 {
    public static void main(String[] args) {
        final DeveloperFactory developerFactory = createDeveloperBySpeciality("java");
        final Developer developer = developerFactory.createDeveloper();

        developer.writeCode();
    }

    static DeveloperFactory createDeveloperBySpeciality(String speciality) {
        if (speciality.equalsIgnoreCase("java")) {
            return new JavaDeveloperFactory();
        } else if (speciality.equalsIgnoreCase("c++")) {
            return new CppDeveloperFactory();
        } else if (speciality.equalsIgnoreCase("php")) {
            return new PhpDeveloperFactory();
        } else {
            throw new RuntimeException(speciality + " is unknown speciality.");
        }
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

class PhpDeveloper implements Developer {

    @Override
    public void writeCode() {
        System.out.println("Php developer writes Php code...");
    }
}

interface DeveloperFactory {
    Developer createDeveloper();
}

class JavaDeveloperFactory implements DeveloperFactory {

    @Override
    public Developer createDeveloper() {
        return new JavaDeveloper();
    }
}

class CppDeveloperFactory implements DeveloperFactory {

    @Override
    public Developer createDeveloper() {
        return new CppDeveloper();
    }
}

class PhpDeveloperFactory implements DeveloperFactory {

    @Override
    public Developer createDeveloper() {
        return new PhpDeveloper();
    }
}