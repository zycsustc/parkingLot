package com.practice.parkingLot;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ParkingSpotTest {
    @Test
    void shouldParkCorrectCar(){
        Car car = new Car("A11111");
        ParkingSpot parkingSpot = new ParkingSpot("1");
        parkingSpot.parkCar(car);

        assertEquals(car.getNumber(), parkingSpot.getCarNumber());
    }

    @Test
    void shouldPickCorrectCar(){
        Car car = new Car("B11111");
        ParkingSpot parkingSpot = new ParkingSpot("1");
        parkingSpot.parkCar(car);

        Car newCar = parkingSpot.getCar();

        assertEquals(car, newCar);
    }
}
