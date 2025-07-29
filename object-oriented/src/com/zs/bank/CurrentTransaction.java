package com.zs.bank;

public class CurrentTransaction extends SavingTransaction {
    private double overdraft;

    public CurrentTransaction() {}
    public CurrentTransaction(String type, double amount, double balance, double overdraft) {
        super(type, amount, balance);
        this.overdraft = overdraft;
    }

    @Override
    public String toString() {
        return super.toString() + "\t" + overdraft;
    }
}
