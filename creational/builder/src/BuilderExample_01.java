/**
 * Wikipedia says
 *
 * The builder pattern is an object creation software design pattern with the intentions of finding a solution to the telescoping constructor anti-pattern.
 *
 * So we can create any objects by setting the parameters that we need.
 */
public class BuilderExample_01 {
    public static void main(String[] args) {

        Person person = new PersonBuilderImpl().setFirstname("Mike").setAge(30).build();
        System.out.println(person);
    }
}

class Person {

    String firstname;
    String lastname;
    int age;
    double salary;

    @Override
    public String toString() {
        return "Person{" +
                "firstname='" + this.firstname + '\'' +
                ", lastname='" + this.lastname + '\'' +
                ", age=" + this.age +
                ", salary=" + this.salary +
                '}';
    }
}

interface PersonBuilder {
    PersonBuilder setFirstname(String firstname);
    PersonBuilder setLastname(String lastname);
    PersonBuilder setAge(int age);
    PersonBuilder setSalary(double salary);
    Person build();
}

class PersonBuilderImpl implements PersonBuilder {

    private Person person = new Person();

    @Override
    public PersonBuilder setFirstname(final String firstname) {
        person.firstname = firstname;
        return this;
    }

    @Override
    public PersonBuilder setLastname(final String lastname) {
        person.lastname = lastname;
        return this;
    }

    @Override
    public PersonBuilder setAge(final int age) {
        person.age = age;
        return this;
    }

    @Override
    public PersonBuilder setSalary(final double salary) {
        person.salary = salary;
        return this;
    }

    @Override
    public Person build() {
        return this.person;
    }
}