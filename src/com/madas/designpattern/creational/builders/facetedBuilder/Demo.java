package com.madas.designpattern.creational.builders.facetedBuilder;

public class Demo {
    public static void main(String[] args) {
        PersonBuilder pb = new PersonBuilder();
        pb.lives().at("Briagade Northridge").in("Bangalore").withPostCode("560064").works().at("TCS").as("Developer").earning(123123);
        System.out.println(pb.build());
    }
}

class Person {
    //Address Details
    public String streetAddress;
    public String postCode;
    public String city;

    //Job Details
    public String company;
    public String role;
    public int annualIncome;

    @Override
    public String toString() {
        return "Person{" +
                "streetAddress='" + streetAddress + '\'' +
                ", postCode='" + postCode + '\'' +
                ", city='" + city + '\'' +
                ", company='" + company + '\'' +
                ", role='" + role + '\'' +
                ", annualIncome=" + annualIncome +
                '}';
    }
}

//Builder Facade
class PersonBuilder {
    protected Person person = new Person();

    public PersonAddressBuilder lives() {
        return new PersonAddressBuilder(person);
    }

    public PersonJobBuilder works() {
        return new PersonJobBuilder(person);
    }
    public Person build() {
        return person;
    }
}

class PersonAddressBuilder extends PersonBuilder {
    public PersonAddressBuilder(Person person) {
        this.person = person;
    }

    public PersonAddressBuilder at(String streetAddress) {
        person.streetAddress = streetAddress;
        return this;
    }

    public PersonAddressBuilder withPostCode(String postCode) {
        person.postCode = postCode;
        return this;
    }

    public PersonAddressBuilder in(String city) {
        person.city = city;
        return this;
    }
}

class PersonJobBuilder extends PersonBuilder {
    public PersonJobBuilder(Person person) {
        this.person = person;
    }

    public PersonJobBuilder at(String company) {
        person.company = company;
        return this;
    }

    public PersonJobBuilder as(String position) {
        person.role = position;
        return this;
    }

    public PersonJobBuilder earning(int salary) {
        person.annualIncome = salary;
        return this;
    }
}