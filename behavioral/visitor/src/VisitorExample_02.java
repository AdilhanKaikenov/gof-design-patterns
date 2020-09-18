/**
 * There is an interface ProjectElement that can be visited by the Developer (Visitor)
 */
public class VisitorExample_02 {
    public static void main(String[] args) {
        Project project = new Project();

        Developer junior = new JuniorDeveloper();
        Developer senior = new SeniorDeveloper();

        System.out.println("Junior in action...");

        project.beWritten(junior);

        System.out.println("\n==================================\n");

        System.out.println("Senior in action...");

        project.beWritten(senior);
    }
}

interface Developer {
    void create(Database database);

    void create(ProjectClass projectClass);

    void create(Test test);
}

class JuniorDeveloper implements Developer {
    @Override
    public void create(Database database) {
        System.out.println("Drop database...");
    }

    @Override
    public void create(ProjectClass projectClass) {
        System.out.println("Writing poor class...");
    }

    @Override
    public void create(Test test) {
        System.out.println("Creating not reliable test...");
    }
}

class SeniorDeveloper implements Developer {
    @Override
    public void create(Database database) {
        System.out.println("Fixing database...");
    }

    @Override
    public void create(ProjectClass projectClass) {
        System.out.println("Rewriting class after junior...");
    }

    @Override
    public void create(Test test) {
        System.out.println("Creating reliable test...");
    }
}

interface ProjectElement {
    void beWritten(Developer developer);
}

class Database implements ProjectElement {
    @Override
    public void beWritten(Developer developer) {
        developer.create(this);
    }
}

class ProjectClass implements ProjectElement {
    @Override
    public void beWritten(Developer developer) {
        developer.create(this);
    }
}

class Test implements ProjectElement {
    @Override
    public void beWritten(Developer developer) {
        developer.create(this);
    }
}

class Project implements ProjectElement {

    ProjectElement[] projectElements;

    public Project() {
        this.projectElements = new ProjectElement[] {
                new ProjectClass(),
                new Database(),
                new Test()
        };
    }

    @Override
    public void beWritten(Developer developer) {
        for (ProjectElement projectElement : this.projectElements) {
            projectElement.beWritten(developer);
        }
    }
}