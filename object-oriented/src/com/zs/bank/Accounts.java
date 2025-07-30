package com.zs.bank;

public abstract class Accounts implements Bank {
    private int acntNo;
    private String holder;
    protected double balance;
    protected SavingTransaction[] txns;
    protected int idx;

    private static int generator = INIT_ACNT_NO;

    public Accounts(){}
    public Accounts(String holder, double balance) {
        this.acntNo = generator++;
        this.holder = holder;
        this.balance = balance;
    }

    public void summary() {
        System.out.println("A/C No: " + acntNo);
        System.out.println("com.zs.bse.Holder: " + holder);
        System.out.println("Balance: " + balance);
    }

    // BL Methods
    public double deposit(double amount) {
        this.balance += amount;
        txns[idx ++] = new SavingTransaction("Credit", amount, balance);
        return balance;
    }

    public double getBalance() {
        return balance;
    }

    public void statement() {
        System.out.println("Statement of A/C No: " + acntNo);
        for(int i = 0; i < idx; i++)
            System.out.println(txns[i]);
    }
}
