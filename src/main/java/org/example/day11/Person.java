package org.example.day11;

import java.util.List;

public final class Person {
    private String name;
    private int age;
    private Address address;
    private List<String> hobbies;

    public Person(String name, int age, Address address, List<String> hobbies) {
        this.name = name;
        this.age = age;
        this.address = address;
        this.hobbies = List.copyOf(hobbies);
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public Address getAddress() {
        return address;
    }

    public List<String> getHobbies() {
        return hobbies;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", address=" + address +
                ", hobbies=" + hobbies +
                '}';
    }
}
