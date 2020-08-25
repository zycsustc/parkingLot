package com.practice.parkingLot;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TicketTest {
    @Test
    void shouldCreateCorrectTicket(){
        Car car = new Car("AB1234");
        String parkingPlace = "A1";
        Ticket ticket = new Ticket(parkingPlace, car);

        assertEquals(car, ticket.getParkedCar());
        assertEquals(parkingPlace, ticket.getParkingPlace());
    }
}
