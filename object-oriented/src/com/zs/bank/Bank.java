package com.zs.bank;

public interface Bank {
    // Application Constants
    int INIT_ACNT_NO = 12001;
    double MIN_SAVINGS_BAL = 1000;
    double INIT_CURRENT_BAL = 5000;
    double MIN_CURRENT_BAL = 0;
    double OVERDRAFT_LIMIT = 10000;
    // Application interface
    void summary();
    double getBalance();
    double deposit(double amount);
    double withdraw(double amount) throws BalanceException;
    void statement();
}
