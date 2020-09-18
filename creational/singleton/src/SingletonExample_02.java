import sun.misc.Unsafe;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;

/**
 * Wikipedia says
 *
 * In software engineering, the singleton pattern is a software design pattern that restricts the instantiation of a class to one object.
 * This is useful when exactly one object is needed to coordinate actions across the system.
 */
public class SingletonExample_02 {
    public static void main(String[] args) throws IllegalAccessException, InstantiationException, ClassNotFoundException, NoSuchFieldException {

        EnumSingleton enumSingletonOne = EnumSingleton.INSTANCE;
        EnumSingleton enumSingletonTwo = EnumSingleton.INSTANCE;

        System.out.println(enumSingletonOne == enumSingletonTwo); // true, the same object

        // #1 - Serializable
        try (FileOutputStream fileOutputStream = new FileOutputStream("test.doc");
             ObjectOutputStream out = new ObjectOutputStream(fileOutputStream);
             FileInputStream fileInputStream = new FileInputStream("test.doc");
             ObjectInputStream in = new ObjectInputStream(fileInputStream)) {

            out.writeObject(enumSingletonOne);
            enumSingletonOne = (EnumSingleton) in.readObject();

            System.out.println("Serializable: " + (enumSingletonOne == enumSingletonTwo)); // true, the same object

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        // #2 - Reflection
        Constructor<EnumSingleton> constructor = (Constructor<EnumSingleton>) EnumSingleton.class.getDeclaredConstructors()[0];
        constructor.setAccessible(true);
//        java.lang.IllegalArgumentException: Cannot reflectively create enum objects
//        EnumSingleton enumSingletonThree = constructor.newInstance();

        // #3 - Class loader
        ClassLoader classLoader = EnumSingleton.class.getClassLoader();
        Class<?> loadClass = classLoader.loadClass("EnumSingleton");

        EnumSingleton enumSingletonThree = (EnumSingleton) loadClass.getEnumConstants()[0];
        System.out.println("Class loader: " + (enumSingletonThree == EnumSingleton.INSTANCE)); // true, the same object

        // #4 - Unsafe - An object that allows us to write data outside the heap, to some native memory area
        Field theUnsafe = Unsafe.class.getDeclaredField("theUnsafe");
        theUnsafe.setAccessible(true);
        Unsafe unsafe = (Unsafe) theUnsafe.get(null);

        EnumSingleton enumSingletonFour = (EnumSingleton) unsafe.allocateInstance(EnumSingleton.class);
        System.out.println("Unsafe: " + (enumSingletonFour == EnumSingleton.INSTANCE)); // false
    }
}

// Enum implicitly marked as final, so we can not call super in constructor
enum EnumSingleton implements Serializable {
    INSTANCE;

    private int index;

    public int getIndex() {
        return this.index;
    }

    public void setIndex(final int index) {
        this.index = index;
    }
}