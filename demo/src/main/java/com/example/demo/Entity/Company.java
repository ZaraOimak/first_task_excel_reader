package com.example.demo.Entity;

public class Company extends Employee {
    private String name;
    private String type;

    public Company(long id, String email, String phone, String address, BankAccount bankAccount, String name, String type) {
        super(id, email, phone, address, bankAccount);
        this.name = name;
        this.type = type;
    }

    @Override
    public String toString() {
        return "Company{" +
                "name='" + name + '\'' +
                ", type='" + type + '\'' +
                "} " + super.toString();
    }
}
