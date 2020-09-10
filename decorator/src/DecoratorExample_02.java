/**
 * Dynamically adding new responsibilities to an object.
 */
public class DecoratorExample_02 {
    public static void main(String[] args) {
        final Developer developer = new JavaTeamLead(new SeniorJavaDeveloper(new JavaDeveloper()));
        System.out.println(developer.makeJob());
    }
}

interface Developer {
    String makeJob();
}

class DeveloperDecorator implements Developer {

    private Developer developer;

    public DeveloperDecorator(final Developer developer) {
        this.developer = developer;
    }

    @Override
    public String makeJob() {
        return this.developer.makeJob();
    }
}

class JavaDeveloper implements Developer {

    @Override
    public String makeJob() {
        return "Write Java code.";
    }
}

class SeniorJavaDeveloper extends DeveloperDecorator {

    public SeniorJavaDeveloper(final Developer developer) {
        super(developer);
    }

    public String makeCodeReview() {
        return " Make Code Review.";
    }

    @Override
    public String makeJob() {
        return super.makeJob() + this.makeCodeReview();
    }
}

class JavaTeamLead extends DeveloperDecorator {

    public JavaTeamLead(final Developer developer) {
        super(developer);
    }

    public String sendWeekReport() {
        return " Send week report to the customer.";
    }

    @Override
    public String makeJob() {
        return super.makeJob() + this.sendWeekReport();
    }
}