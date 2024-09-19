package com.example.demo.Entity;

public class Individual extends Employee {
    private String firstName;
    private String lastName;
    private boolean hasChildren;
    private int age;

    public Individual(long id, String email, String phone, String address, BankAccount bankAccount, String firstName, String lastName, boolean hasChildren, int age) {
        super(id, email, phone, address, bankAccount);
        this.firstName = firstName;
        this.lastName = lastName;
        this.hasChildren = hasChildren;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Individual{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", hasChildren=" + hasChildren +
                ", age=" + age +
                "} " + super.toString();
    }
}
