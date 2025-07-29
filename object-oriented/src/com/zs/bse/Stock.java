package com.zs.bse;

public class Stock implements Exchange {
    @Override
    public void set() {
        System.out.println("Set quote");
    }

    @Override
    public void get() {
        System.out.println("Get quote");
    }

    @Override
    public void view() {
        System.out.println("View quote");
    }
}
