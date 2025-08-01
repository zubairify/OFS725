package com.tw.bean;

public class Vehicle {
    private int code;
    private String model;
    private String brand;
    private String color;
    private String fuel;
    private double cost;

    public Vehicle() {}
    public Vehicle(int code, String model, String brand, String color, String fuel, double cost) {
        this.code = code;
        this.model = model;
        this.brand = brand;
        this.color = color;
        this.fuel = fuel;
        this.cost = cost;
    }

    @Override
    public String toString() {
        return "Code: " + code + ", Model: " + model + ", Brand: " + brand + ", Color: " + color + ", Fuel: " + fuel;
    }

    public int getCode() {
        return code;
    }

    public String getBrand() {
        return brand;
    }

    public String getColor() {
        return color;
    }

    public String getFuel() {
        return fuel;
    }

    public double getCost() {
        return cost;
    }

    public String getModel() {
        return model;
    }
}
