import sun.misc.Unsafe;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

/**
 * Considered bad practice unlike Enum, @see SingletonExample_02
 */
public class SingletonExample_01 {
    public static void main(String[] args) throws IllegalAccessException, InvocationTargetException, InstantiationException, ClassNotFoundException, NoSuchFieldException {

        Singleton singletonOne = Singleton.getInstance();
        Singleton singletonTwo = Singleton.getInstance();

        System.out.println(singletonOne == singletonTwo); // true, the same object

        // It is considered bad practice because we can create multiple instances of a given singleton (there are 4 ways)

        // #1 - Serializable
        try (FileOutputStream fileOutputStream = new FileOutputStream("test.doc");
             ObjectOutputStream out = new ObjectOutputStream(fileOutputStream);
             FileInputStream fileInputStream = new FileInputStream("test.doc");
             ObjectInputStream in = new ObjectInputStream(fileInputStream)) {

            out.writeObject(singletonOne);
            singletonOne = (Singleton) in.readObject();

            System.out.println("Serializable: " + (singletonOne == singletonTwo)); // false

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        // #2 - Reflection
        Constructor<Singleton> constructorOne = (Constructor<Singleton>) Singleton.class.getDeclaredConstructors()[0];
        constructorOne.setAccessible(true);
        Singleton singletonThree = constructorOne.newInstance();

        System.out.println("Reflection: " + (singletonThree == Singleton.getInstance())); // false

        // #3 - Class loader
        ClassLoader classLoader = Singleton.class.getClassLoader();
        Class<?> loadClass = classLoader.loadClass("Singleton");

        Constructor<Singleton> constructorTwo = (Constructor<Singleton>) loadClass.getDeclaredConstructors()[0];
        constructorTwo.setAccessible(true);
        Singleton singletonFour = constructorTwo.newInstance();

        System.out.println("Class loader: " + (singletonFour == Singleton.getInstance())); // false

        // #4 - Unsafe - An object that allows us to write data outside the heap, to some native memory area
        Field theUnsafe = Unsafe.class.getDeclaredField("theUnsafe");
        theUnsafe.setAccessible(true);
        Unsafe unsafe = (Unsafe) theUnsafe.get(null);

        Singleton singletonFive = (Singleton) unsafe.allocateInstance(Singleton.class);
        System.out.println("Unsafe: " + (singletonFive == Singleton.getInstance())); // false
    }
}

class Singleton implements Serializable {
    private int index;

    private static Singleton INSTANCE;

    // private constructor
    private Singleton() {
    }

    public int getIndex() {
        return this.index;
    }

    public void setIndex(final int index) {
        this.index = index;
    }

    // Lazy initialization
    public static Singleton getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new Singleton();
        }

        return INSTANCE;
    }
}