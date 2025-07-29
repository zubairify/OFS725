package com.zs.bank;

public class SavingTransaction {
    private String type;
    private double amount;
    private double balance;

    public SavingTransaction() {}
    public SavingTransaction(String type, double amount, double balance) {
        this.type = type;
        this.amount = amount;
        this.balance = balance;
    }

    @Override
    public String toString() {
        return type + "\t" + amount + "\t" + balance;
    }
}
