package com.practice.parkingLot;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TicketTest {
    @Test
    void shouldCreateCorrectTicket(){
        Car car = new Car("AB1234");
        String parkingSpotId = "A:0";
        Ticket ticket = new Ticket(parkingSpotId, car.getNumber());

        assertEquals(car.getNumber(), ticket.getCarNumber());
        assertEquals(parkingSpotId, ticket.getParkingSpotId());
    }
}
