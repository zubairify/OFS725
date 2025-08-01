package com.tw.dao;

import com.tw.bean.Vehicle;

import java.util.List;

public class VehicleDaoJdbcImpl implements VehicleDao {
    @Override
    public boolean add(Vehicle vehicle) {
        return false;
    }

    @Override
    public Vehicle findByCode(int code) {
        return null;
    }

    @Override
    public List<Vehicle> findAll() {
        return List.of();
    }

    @Override
    public List<Vehicle> findByBrand(String brand) {
        return List.of();
    }

    @Override
    public List<Vehicle> findByColor(String color) {
        return List.of();
    }

    @Override
    public List<Vehicle> findByFuel(String fuel) {
        return List.of();
    }

    @Override
    public List<Vehicle> findByCostRange(double min, double max) {
        return List.of();
    }
}
