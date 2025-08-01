package com.tw.service;

import static org.junit.jupiter.api.Assertions.*;

import com.tw.bean.Vehicle;
import com.tw.dao.VehicleDao;
import com.tw.dao.VehicleDaoImpl;
import com.tw.util.InvalidVehicleException;
import org.junit.jupiter.api.*;

class TestVehicleServiceImpl {
    private static VehicleService vehicleService;

    @BeforeAll
    public static void setUp() {
        VehicleDao dao = new VehicleDaoImpl();
        vehicleService = new VehicleServiceImpl(dao);
    }

    @Test
    void testAdd() {
        Vehicle thar = new Vehicle(107,"Thar","Mahindra","Black","Diesel",125000);
        assertTrue(vehicleService.add(thar));
    }

    @Test
    void testFindByCode() {
        assertNotNull(vehicleService.findByCode(107));
    }

    @Test
    void testFindByInvalidCode() {
        assertThrows(InvalidVehicleException.class,
                () -> vehicleService.findByCode(100));
    }

    @Test
    void testFindAll() {
        assertTrue(vehicleService.findAll().size()>0);
    }

    @Test
    void testFindByBrand() {
    }

    @Test
    void testFindByBrandEmpty() {
    }

    @Test
    void testFindByColor() {
    }

    @Test
    void testFindByColorEmpty() {
    }

    @Test
    void testFindByFuel() {
    }

    @Test
    void testFindByFuelEmpty() {
    }

    @Test
    void testFindByCostRange() {
    }

    @Test
    void testFindByCostRangeEmpty() {
    }
}