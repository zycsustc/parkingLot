package com.practice.parkingLot;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CarTest {
    @Test
    void shouldCreateCorrectCar(){
        String number = "AB1234";
        Car car = new Car(number);

        assertEquals(number, car.getNumber());
    }

}
