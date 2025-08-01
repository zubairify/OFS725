package com.tw.service;

import com.tw.bean.Vehicle;

import java.util.List;

public interface VehicleService {
    boolean add(Vehicle vehicle);
    Vehicle findByCode(int code);
    List<Vehicle> findAll();
    List<Vehicle> findByBrand(String brand);
    List<Vehicle> findByColor(String color);
    List<Vehicle> findByFuel(String fuel);
    List<Vehicle> findByCostRange(double min, double max);
}
