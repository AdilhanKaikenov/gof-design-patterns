import java.util.ArrayList;
import java.util.List;

public class ObserverExample_03 {
    public static void main(String[] args) {
        JavaDeveloperJobSite jobSite = new JavaDeveloperJobSite();

        jobSite.addVacancy("First Java Position");
        jobSite.addVacancy("Second Java Position");

        Observer firstSubscriber = new MySubscriber("Sasha");
        Observer secondSubscriber = new MySubscriber("Masha");

        jobSite.addObserver(firstSubscriber);
        jobSite.addObserver(secondSubscriber);

        jobSite.addVacancy("Third Java Position");
        jobSite.removeVacancy("First Java Position");

    }
}

interface Observer {
    void handleEvent(List<String> vacancies);
}

interface Observed {
    void addObserver(Observer observer);

    void removeObserver(Observer observer);

    void notifyObservers();
}

class MySubscriber implements Observer {
    private String name;

    public MySubscriber(final String name) {
        this.name = name;
    }

    @Override
    public void handleEvent(final List<String> vacancies) {
        System.out.println("Dear " + this.name + "\nWe have some changes in out vacancies:\n " + vacancies +
                "\n=============================================================\n");
    }
}

class JavaDeveloperJobSite implements Observed {

    private List<Observer> subscribers = new ArrayList<>();

    private List<String> vacancies = new ArrayList<>();

    public void addVacancy(String vacancy) {
        this.vacancies.add(vacancy);
        this.notifyObservers();
    }

    public void removeVacancy(String vacancy) {
        this.vacancies.remove(vacancy);
        this.notifyObservers();
    }

    @Override
    public void addObserver(final Observer observer) {
        this.subscribers.add(observer);
    }

    @Override
    public void removeObserver(final Observer observer) {
        this.subscribers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer subscriber : this.subscribers) {
            subscriber.handleEvent(this.vacancies);
        }
    }
}