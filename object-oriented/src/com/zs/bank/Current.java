package com.zs.bank;

public class Current extends Accounts {
    private double overdraft;

    public Current() {}
    public Current(String holder) {
        super(holder, INIT_CURRENT_BAL);
        this.overdraft = OVERDRAFT_LIMIT;
        txns = new CurrentTransaction[10];
        txns[idx ++] = new CurrentTransaction(
                "Opening", INIT_CURRENT_BAL, INIT_CURRENT_BAL, OVERDRAFT_LIMIT);
    }

    @Override
    public double deposit(double amount) {
        overdraft += amount;
        if(overdraft > OVERDRAFT_LIMIT) {
            balance += overdraft - OVERDRAFT_LIMIT;
            overdraft = OVERDRAFT_LIMIT;
        }
        txns[idx ++] = new CurrentTransaction("Credit", amount, balance, overdraft);
        return balance;
    }

    @Override
    public double withdraw(double amount) {
        if(amount <= (balance + overdraft)) {
            balance -= amount;
            if(balance < MIN_CURRENT_BAL) {
                overdraft += balance;
                balance = MIN_CURRENT_BAL;
            }
            txns[idx ++] = new CurrentTransaction("Debit", amount, balance, overdraft);
        } else
            System.out.println("Insufficient funds");
        return balance;
    }

    @Override
    public double getBalance() {
        return super.getBalance() + overdraft;
    }

    @Override
    public void summary() {
        super.summary();
        System.out.println("Overdraft: " + overdraft);
    }
}
