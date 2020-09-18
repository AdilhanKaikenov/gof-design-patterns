package example_03;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Use the Flyweight pattern only when your program must support a huge number of objects which barely fit into available RAM.
 */
public class FlyweightExample_03 {
    public static void main(String[] args) {
        final DeveloperFactory developerFactory = new DeveloperFactory();

        List<Developer> developers = new ArrayList<>();

        developers.add(developerFactory.getDeveloperBySpeciality("java"));
        developers.add(developerFactory.getDeveloperBySpeciality("java"));
        developers.add(developerFactory.getDeveloperBySpeciality("java"));
        developers.add(developerFactory.getDeveloperBySpeciality("java"));
        developers.add(developerFactory.getDeveloperBySpeciality("java"));
        developers.add(developerFactory.getDeveloperBySpeciality("java"));
        developers.add(developerFactory.getDeveloperBySpeciality("java"));
        developers.add(developerFactory.getDeveloperBySpeciality("c++"));
        developers.add(developerFactory.getDeveloperBySpeciality("c++"));
        developers.add(developerFactory.getDeveloperBySpeciality("c++"));
        developers.add(developerFactory.getDeveloperBySpeciality("c++"));
        developers.add(developerFactory.getDeveloperBySpeciality("c++"));
        developers.add(developerFactory.getDeveloperBySpeciality("c++"));
        developers.add(developerFactory.getDeveloperBySpeciality("c++"));

        for (final Developer developer : developers) {
            developer.writeCode();
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

class DeveloperFactory {
    private static final Map<String, Developer> DEVELOPERS = new HashMap<>();

    public Developer getDeveloperBySpeciality(String speciality) {
        Developer developer = DEVELOPERS.get(speciality);

        if (developer == null) {
            switch (speciality) {
                case "java":
                    System.out.println("Hiring Java developer...");
                    developer = new JavaDeveloper();
                    break;
                case "c++":
                    System.out.println("Hiring C++ developer...");
                    developer = new CppDeveloper();
                    break;
                default:
                    throw new IllegalArgumentException();
            }
            DEVELOPERS.put(speciality, developer);
        }

        return developer;
    }
}