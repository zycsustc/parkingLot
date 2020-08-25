package com.practice.parkingLot;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ParkingLotTest {
    Message message = new Message();

    @Test
    void shouldReturnTicketWhenOnlyOneEmptyParkingPlace(){
        Car car = new Car("AB1234");
        ParkingLot parkingLot = new ParkingLot(1);
        Ticket ticket = parkingLot.park(car);

        assertEquals(car, ticket.getParkedCar());
    }

    @Test
    void shouldReturnMultiTicketsWhenHavingMultiParkingPlaces(){
        Car car1 = new Car("A11111");
        Car car2 = new Car("B11111");
        ParkingLot parkingLot = new ParkingLot(2);

        Ticket ticket1 = parkingLot.park(car1);
        Ticket ticket2 = parkingLot.park(car2);

        assertEquals(car1, ticket1.getParkedCar());
        assertEquals(car2, ticket2.getParkedCar());
        assertNotEquals(ticket1.getParkingPlace(), ticket2.getParkingPlace());
    }

    @Test
    void shouldFailedWhenParkingLotIsFull(){
        Car car = new Car("A11111");
        ParkingLot parkingLot = new ParkingLot(0);

        Ticket ticket = parkingLot.park(car);

        assertEquals(message.fullMessage, ticket.getParkingPlace());
    }

}