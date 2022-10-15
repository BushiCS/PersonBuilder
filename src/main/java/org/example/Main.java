package org.example;

public class Main {
    public static void main(String[] args) {
        PersonBuilder builder = new PersonBuilder();
        Person aunt = builder.name("Julia")
                .surname("Roberts")
                .age(54)
                .city("New York")
                .build();
        aunt.setAddress("Los Angeles");
        System.out.println(aunt);
        Person niece = aunt.newChildBuilder()
                .name("Emma")
                .age(31)
                .build();
        niece.happyBirthday();
        System.out.println(niece);
    }
}