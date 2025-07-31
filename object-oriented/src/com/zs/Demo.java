package com.zs;

public class Demo<Z> {
    private Z data;

    public Demo(Z data) {
        this.data = data;
    }
    public void setData(Z data) {
        this.data = data;
    }
    public Z getData() {
        return data;
    }

    public static void main(String[] args) {
        Demo<String> d1 = new Demo<String>("Hello");
        Demo<Double> d2 = new Demo<Double>(3.14);

        System.out.println(d1.getData());
        System.out.println(d2.getData());
    }
}

class SubDemo<S,Z> extends Demo<Z> {
    private S sample;

    SubDemo(S sample, Z data) {
        super(data);
        this.sample = sample;
    }
}