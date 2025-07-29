package com.zs.bank;

public abstract class Accounts {
    // Application Constants
    public static final int INIT_ACNT_NO = 12001;
    public static final double MIN_SAVINGS_BAL = 1000;
    public static final double INIT_CURRENT_BAL = 5000;
    public static final double MIN_CURRENT_BAL = 0;
    public static final double OVERDRAFT_LIMIT = 10000;

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

    public abstract double withdraw(double amount);

    public double getBalance() {
        return balance;
    }

    public void statement() {
        System.out.println("Statement of A/C No: " + acntNo);
        for(int i = 0; i < idx; i++)
            System.out.println(txns[i]);
    }
}
