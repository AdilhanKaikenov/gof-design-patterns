/**
 * Cloning through the interface Cloning is a bad practice, because when we do cloning, the code in the constructor is not executed,
 * in which the object's settings may be and If we have fields marked as final, then we will not be able to clone them.
 *
 * Example of constructors for cloning
 */
public class PrototypeExample_01 {
    public static void main(String[] args) {
        Address street = new Address("Street", 10);
        Person person = new Person("Mike", 22, street);

        Person person2 = new Person(person);
        System.out.println(person != person2);
        System.out.println(person.name == person2.name);
        System.out.println(person.address != person2.address);
    }
}

class Address {
    String street;
    int number;

    public Address(final String street, final int number) {
        this.street = street;
        this.number = number;
    }

    public Address(final Address address) {
        this.street = address.street;
        this.number = address.number;
    }
}

class Person {

    String name;
    int age;
    Address address;

    public Person(final String name, final int age, final Address address) {
        System.out.println("Constructor 1");
        this.name = name;
        this.age = age;
        this.address = address;
    }

    public Person(final Person person) {
        System.out.println("Constructor 2");
        this.name = person.name;
        this.age = person.age;
        this.address = new Address(person.address);
    }
}