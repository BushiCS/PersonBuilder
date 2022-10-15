package org.example;
import java.util.OptionalInt;

public class Person {
    private final String name;
    private final String surname;
    private int age;
    private String city;

    public Person(String name, String surname, int age, String city) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.city = city;
    }

    public PersonBuilder newChildBuilder() {
        return new PersonBuilder().surname(getSurname()).city(getCity());
    }

    public int happyBirthday() {
        if (hasAge()) {
            System.out.println("Happy Birthday, " + getName() + "!");
            age++;
            return age;
        }
        return 0;
    }

    public boolean hasAge() {
        return getAge().isPresent();
    }

    public void setAddress(String city) {
        this.city = city;
    }

    public boolean hasAddress() {
        return getCity() != null;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public OptionalInt getAge() {
        return OptionalInt.of(age);
    }

    public String getCity() {
        return city;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", age=" + age +
                ", city='" + city + '\'' +
                '}';
    }
}
