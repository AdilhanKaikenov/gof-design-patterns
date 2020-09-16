import java.io.Serializable;

public class SingletonExample_03 {
    public static void main(String[] args) throws InterruptedException {
        SingletonWrapper singletonWrapperOne = new SingletonWrapper();
        SingletonWrapper singletonWrapperTwo = new SingletonWrapper();

        Thread threadOne = new Thread(() -> {
            singletonWrapperOne.treadSafeSingleton = TreadSafeSingleton.getInstance();
            singletonWrapperOne.enumSingleton = EnumSingleton.INSTANCE;
        });

        Thread threadTwo = new Thread(() -> {
            singletonWrapperTwo.treadSafeSingleton = TreadSafeSingleton.getInstance();
            singletonWrapperTwo.enumSingleton = EnumSingleton.INSTANCE;
        });

        threadOne.start();
        threadTwo.start();

        threadOne.join();
        threadTwo.join();

        System.out.println(singletonWrapperOne.treadSafeSingleton == singletonWrapperTwo.treadSafeSingleton);
        System.out.println(singletonWrapperOne.enumSingleton == singletonWrapperTwo.enumSingleton);
    }
}

class SingletonWrapper {
    TreadSafeSingleton treadSafeSingleton;
    EnumSingleton enumSingleton;
}

class TreadSafeSingleton implements Serializable {
    private int index;

    private volatile static TreadSafeSingleton INSTANCE; // volatile

    // private constructor
    private TreadSafeSingleton() {
    }

    public int getIndex() {
        return this.index;
    }

    public void setIndex(final int index) {
        this.index = index;
    }

    // Lazy initialization
    // if a method is marked as synchronized, then it takes a very long time to run, because a synchronized method is a rather complex operation
    // that needs to be synchronized a lot, so it is better to use double check
    public static TreadSafeSingleton getInstance() {
        if (INSTANCE == null) { // the first check
            synchronized (TreadSafeSingleton.class) {
                if (INSTANCE == null) { // the second check
                    System.out.println("Current Thread Name: " + Thread.currentThread().getName());
                    INSTANCE = new TreadSafeSingleton();
                }
            }
        }

        return INSTANCE;
    }
}