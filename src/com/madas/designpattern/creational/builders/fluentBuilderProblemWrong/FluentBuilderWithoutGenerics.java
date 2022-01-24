package com.madas.designpattern.creational.builders.fluentBuilderProblemWrong;

public class FluentBuilderWithoutGenerics {
    public static void main(String[] args) {
        PersonBuilder pb = new PersonBuilder();
        pb.withName("Madas");
        // I cannot call .withPosition because withName still returns PersonBuilder type. This problem occurs when Builders extend each other. To fix this we
        // need to use generics
        System.out.println(pb.build());
    }
}

class Person {
    public String name;
    public String position;

    public Person() {
    }

    public Person(String name, String position) {
        this.name = name;
        this.position = position;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", position='" + position + '\'' +
                '}';
    }
}

class PersonBuilder {
    Person person = new Person();

    public PersonBuilder withName(String name) {
        person.name = name;
        return this;
    }

    public Person build() {
        return person;
    }
}

class EmployeeBuilder extends PersonBuilder {
    public EmployeeBuilder withPosition(String position) {
        person.position = position;
        return this;
    }
}

