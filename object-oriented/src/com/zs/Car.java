package com.zs;
import static java.lang.System.*;
import static java.lang.Math.*;

public class Car {
    private String model;
    private String[] features;

    Car(String model, String...features) { //var-args
        this.model = model;
        this.features = features;
    }

    public void specs() {
        System.out.println("Features of " + model);
        for (String f : features)
            System.out.println(f);
    }

    public static void main(String[] args) {
        Car venue = new Car("Hyundai Venue", "ABS","DRL","Rear Cam","Sunroof");
        venue.specs();

        out.println(currentTimeMillis());
        out.println(random());
        out.println(PI);
    }
}
