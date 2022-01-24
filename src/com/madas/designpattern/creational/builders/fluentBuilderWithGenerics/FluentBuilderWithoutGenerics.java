package com.madas.designpattern.creational.builders.fluentBuilderWithGenerics;

public class FluentBuilderWithoutGenerics {
    public static void main(String[] args) {
        EmployeeBuilder pb = new EmployeeBuilder();
        pb.withName("Madas").withPosition("Developer");
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

class PersonBuilder<E extends  PersonBuilder<E>> {
    Person person = new Person();

    public E withName(String name) {
        person.name = name;
        return self();
    }

    public Person build() {
        return person;
    }

    protected E self() {
        return (E) this;
    }
}

class EmployeeBuilder extends PersonBuilder<EmployeeBuilder> {
    public EmployeeBuilder withPosition(String position) {
        person.position = position;
        return this;
    }

    @Override
    protected EmployeeBuilder self() {
        return this;
    }
}

