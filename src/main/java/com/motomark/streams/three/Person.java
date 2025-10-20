package com.motomark.streams.three;

public class Person {

    private final String name;
    private final int age;

    public Person(final String theName, final int theAge) {
        name = theName;
        age = theAge;
    }

    @Override
    public String toString() {
        return String.format("%s - %d", name, age);
    }

    public int ageDifference(final Person other) {
        return age - other.age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    

}
