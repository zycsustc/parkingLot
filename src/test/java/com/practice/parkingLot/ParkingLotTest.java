package com.practice.parkingLot;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ParkingLotTest {
    @Test
    void shouldReturnTicketWhenOnlyOneEmptyParkingPlace(){
        Car car = new Car("AB1234");
        ParkingLot parkingLot = new ParkingLot();
        Ticket ticket = parkingLot.park(car);

        assertEquals(car, ticket.getParkedCar());
    }
}
