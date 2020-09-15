import java.util.ArrayList;
import java.util.List;

public class ObserverExample_01 {
    public static void main(String[] args) {

        Subject subject = new Subject();
        Subscriber1 myObservable = new Subscriber1();
        subject.subscribe(myObservable);
        subject.subscribe(new Subscriber2());

        subject.notifySubscribers("Hello!");

        subject.unsubscribe(myObservable);

        subject.notifySubscribers("Hello!");
    }
}

interface MyObservable {
    void callMe(String mgs);
}

class Subscriber1 implements MyObservable {

    @Override
    public void callMe(String mgs) {
        System.out.println("Subscriber1: " + mgs);
    }
}

class Subscriber2 implements MyObservable {

    @Override
    public void callMe(String mgs) {
        System.out.println("Subscriber2: " + mgs);
    }
}

class Subject {
    private List<MyObservable> observableList = new ArrayList<>();

    public void subscribe(MyObservable myObservable) {
        this.observableList.add(myObservable);
    }

    public void unsubscribe(MyObservable myObservable) {
        this.observableList.remove(myObservable);
    }

    public void notifySubscribers(String mgs) {
        this.observableList.forEach(item -> item.callMe(mgs));
    }
}