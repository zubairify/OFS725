package com.zs.bank;

public final class AccountsFactory {
    private AccountsFactory() {}

    public static Savings openSavings(String holder) {
        return new Savings(holder);
    }

    public static Current openCurrent(String holder) {
        return new Current(holder);
    }
}
