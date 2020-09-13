import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class IteratorExample_01 {
    public static void main(String[] args) {

        final Menu menu = new Menu();

        // #1
        final Iterator<String> iterator = menu.getIterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        // #2
        for (final String item : new Menu()) { // must implement Iterable<T>
            System.out.println(item);
        }

        // #3
        new Menu().forEach(str -> System.out.println(str));

        // Iterators are divided into two types (collection are divided into two types)
        // FAIL FAST and FAIL SAFE
        // (FAIL FAST) If we have some kind of incorrect operation while we are running through the collection, then we will immediately fail
        // (FAIL SAFE) If we have some kind of incorrect operation while we are running through the collection, then nothing will happen, everything will work
        // The difference between them is that the FAIL SAFE works longer, the FAIL FAST works faster

        final List<Object> failFastList = new ArrayList<>();
        failFastList.add("One");
        failFastList.add("Two");
        failFastList.add("Three");
        failFastList.add("Four");
        failFastList.forEach(str -> {
            System.out.println(str);
            failFastList.add("new"); // java.util.ConcurrentModificationException
            failFastList.remove(str); // java.util.ConcurrentModificationException
        });

        final Iterator<Object> listIterator = failFastList.iterator();
        while (listIterator.hasNext()) {
            System.out.println(listIterator.next());
            failFastList.add("new"); // java.util.ConcurrentModificationException
            failFastList.remove("One"); // java.util.ConcurrentModificationException
        }

        final List<Object> failSafeList = new CopyOnWriteArrayList<>();
        failSafeList.add("One");
        failSafeList.add("Two");
        failSafeList.add("Three");
        failSafeList.add("Four");
        failSafeList.forEach(str -> {
            System.out.println(str);
            // No exception, because CopyOnWriteArrayList works with a copy (creates a cpy for each iterator
            // It's bad because it takes time and space.
            failSafeList.remove(str);
        });
    }
}

class Menu implements Iterable<String> {

    private List<String> items = new ArrayList<>();

    public Menu() {
        this.items.add("One");
        this.items.add("Two");
        this.items.add("Three");
        this.items.add("Four");
    }

    public Iterator<String> getIterator() {
        return this.items.iterator();
    }

    @Override
    public Iterator<String> iterator() {
        return this.items.iterator();
    }
}