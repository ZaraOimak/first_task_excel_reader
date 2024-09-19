package com.example.demo.Entity;

public class BankAccount {
    private String iban;
    private String bic;
    private String accountHolder;

    public BankAccount(String iban, String bic, String accountHolder) {
        this.iban = iban;
        this.bic = bic;
        this.accountHolder = accountHolder;
    }

    @Override
    public String toString() {
        return "BankAccount{" +
                "iban='" + iban + '\'' +
                ", bic='" + bic + '\'' +
                ", accountHolder='" + accountHolder + '\'' +
                '}';
    }
}
