package com.practice.parkingLot;

import com.practice.parkingLot.common.Message;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class ParkingBoyTest {
    Message message = new Message();

    @Test
    void shouldParkCarGivenOneParkingLot(){
        ArrayList<ParkingLot> parkingLots = new ArrayList<>();
        parkingLots.add(new ParkingLot(1, "A"));
        ParkingBoy parkingBoy = new ParkingBoy(parkingLots);
        Car firstCar = new Car("A11111");
        Car secondCar = new Car("B11111");
        Ticket ticket = parkingBoy.park(firstCar);
        assertEquals(firstCar.getNumber(), ticket.getCarNumber());
        Ticket secondTicket = parkingBoy.park(secondCar);
        assertEquals(secondTicket.getParkingSpotId(), message.fullMessage);
    }

    @Test
    void shouldPickUpCarGivenOneParkingLot(){
        ArrayList<ParkingLot> parkingLots = new ArrayList<>();
        parkingLots.add(new ParkingLot(2, "A"));
        ParkingBoy parkingBoy = new ParkingBoy(parkingLots);
        Car myCar = new Car("A11111");
        Ticket ticket = parkingBoy.park(myCar);
        Car pickedUpCar = parkingBoy.pickUp(ticket);
        assertEquals(myCar, pickedUpCar);
        Car pickedUpSecondCar = parkingBoy.pickUp(ticket);
        assertEquals(null, pickedUpSecondCar);
    }

    @Test
    void shouldParkCarToTheParkingLotWithHighestVacancyRateGivenMultiPleParkingLots(){
        ParkingLot parkingLotA = new ParkingLot(3, "A");
        ParkingLot parkingLotB = new ParkingLot(2, "B");
        parkingLotA.park(new Car("B11111"));
        parkingLotA.park(new Car("C11111"));
        parkingLotB.park(new Car("A11111"));

        ArrayList<ParkingLot> parkingLots = new ArrayList<>();
        parkingLots.add(parkingLotA);
        parkingLots.add(parkingLotB);
        ParkingBoy parkingBoy = new ParkingBoy(parkingLots);
        Car myCar = new Car("D11111");

        Ticket ticket = parkingBoy.park(myCar);

        assertEquals("B:1", ticket.getParkingSpotId());
    }

    @Test
    void shouldParkCarToTheFirstAvailableParkingLotGivenMultipleParkingLotsWithSameVacancyRate(){
        ArrayList<ParkingLot> parkingLots = new ArrayList<>();
        parkingLots.add(new ParkingLot(2, "A"));
        parkingLots.add(new ParkingLot(2, "B"));
        ParkingBoy parkingBoy = new ParkingBoy(parkingLots);
        Car myCar = new Car("A11111");

        Ticket ticket = parkingBoy.park(myCar);

        assertEquals("A:0", ticket.getParkingSpotId());
    }

    @Test
    void shouldFailOnParkingGivenMultipleFullFilledParkingLots(){
        ArrayList<ParkingLot> parkingLots = new ArrayList<>();
        parkingLots.add(new ParkingLot(1, "A"));
        parkingLots.add(new ParkingLot(1, "B"));
        ParkingBoy parkingBoy = new ParkingBoy(parkingLots);

        parkingBoy.park(new Car("A11111"));
        parkingBoy.park(new Car("A22222"));
        Ticket ticket = parkingBoy.park(new Car("A33333"));

        assertEquals(message.fullMessage, ticket.getParkingSpotId());
    }

    @Test
    void shouldFailOnPickingUpCarGivenInvalidTicket(){
        ArrayList<ParkingLot> parkingLots = new ArrayList<>();
        parkingLots.add(new ParkingLot(1, "A"));
        parkingLots.add(new ParkingLot(1, "B"));
        ParkingBoy parkingBoy = new ParkingBoy(parkingLots);

        parkingBoy.park(new Car("A11111"));
        parkingBoy.park(new Car("B11111"));

        Ticket invalidParkingSpotTicket = new Ticket("Invalid", "A11111");
        Ticket invalidCarNumberTicket = new Ticket("A:0", "Invalid");

        assertNull(parkingBoy.pickUp(invalidParkingSpotTicket));
        assertNull(parkingBoy.pickUp(invalidCarNumberTicket));
    }

    @Test
    void shouldSuccessfullyPickUpCarGivenValidTicketAndTheCarIsParkedInParkingLots(){
        ArrayList<ParkingLot> parkingLots = new ArrayList<>();
        parkingLots.add(new ParkingLot(2, "A"));
        parkingLots.add(new ParkingLot(2, "B"));
        ParkingBoy parkingBoy = new ParkingBoy(parkingLots);
        Car myCar = new Car("A11111");

        Ticket ticket = parkingBoy.park(myCar);

        assertEquals(myCar, parkingBoy.pickUp(ticket));
    }

    @Test
    void shouldFailOnPickUpTheSameCarWithTicketTwice(){
        ArrayList<ParkingLot> parkingLots = new ArrayList<>();
        parkingLots.add(new ParkingLot(2, "A"));
        parkingLots.add(new ParkingLot(2, "B"));
        ParkingBoy parkingBoy = new ParkingBoy(parkingLots);
        Car myCar = new Car("A11111");

        Ticket ticket = parkingBoy.park(myCar);
        Car pickedUpCar = parkingBoy.pickUp(ticket);
        Car secondPickedUpCar = parkingBoy.pickUp(ticket);

        assertNull(secondPickedUpCar);
    }
}
