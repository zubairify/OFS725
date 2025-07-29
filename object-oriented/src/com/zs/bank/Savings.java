package com.zs.bank;

public class Savings extends Accounts {
    public Savings() {}
    public Savings(String holder) {
        super(holder, MIN_SAVINGS_BAL);
        txns = new SavingTransaction[10];
        txns[idx ++] = new SavingTransaction(
                "Opening", MIN_SAVINGS_BAL, MIN_SAVINGS_BAL);
    }

    @Override
    public double withdraw(double amount) {
        if(amount <= (balance - MIN_SAVINGS_BAL)) {
            balance -= amount;
            txns[idx ++] = new SavingTransaction("Debit", amount, balance);
        } else
            System.out.println("Insufficient funds.");
        return balance;
    }
}
