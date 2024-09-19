package com.example.demo.Entity;

public class Employee {
    private long id;
    private String email;
    private String phone;
    private String address;
    private BankAccount bankAccount;

    public Employee(long id, String email, String phone, String address, BankAccount bankAccount) {
        this.id = id;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.bankAccount = bankAccount;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                ", bankAccount=" + bankAccount +
                '}';
    }
}
