package com.practice.parkingLot;

import com.practice.parkingLot.common.Message;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ParkingLotTest {
    Message message = new Message();

    @Test
    void shouldReturnTicketWhenOnlyOneEmptyParkingPlace(){
        Car car = new Car("AB1234");
        ParkingLot parkingLot = new ParkingLot(1, "A");
        Ticket ticket = parkingLot.park(car);

        assertEquals(car.getNumber(), ticket.getCarNumber());
    }

    @Test
    void shouldReturnMultiTicketsWhenHavingMultiParkingPlaces(){
        Car car1 = new Car("A11111");
        Car car2 = new Car("B11111");
        ParkingLot parkingLot = new ParkingLot(2, "A");

        Ticket ticket1 = parkingLot.park(car1);
        Ticket ticket2 = parkingLot.park(car2);

        assertEquals(car1.getNumber(), ticket1.getCarNumber());
        assertEquals(car2.getNumber(), ticket2.getCarNumber());
        assertNotEquals(ticket1.getParkingPlace(), ticket2.getParkingPlace());
    }

    @Test
    void shouldFailedWhenParkingLotIsFull(){
        Car car = new Car("A11111");
        ParkingLot parkingLot = new ParkingLot(0, "A");

        Ticket ticket = parkingLot.park(car);

        assertEquals(message.fullMessage, ticket.getParkingPlace());
    }

    @Test
    void shouldReturnMyCarGivenMyTicketWhenParkingLotOnlyParkedMyCar(){
        Car myCar = new Car("A11111");
        ParkingLot parkingLot = new ParkingLot(1, "A");

        Ticket ticket = parkingLot.park(myCar);
        Car pickedCar = parkingLot.pickCar(ticket);
        assertEquals(myCar, pickedCar);
    }

    @Test
    void shouldReturnMyCarGivenMyTicketWhenParkingLotParkedManyCarsIncludingMyCar(){
        Car myCar = new Car("A11111");
        Car otherCar = new Car("B11111");
        ParkingLot parkingLot = new ParkingLot(2, "A");

        Ticket myTicket = parkingLot.park(myCar);
        Ticket otherTicket = parkingLot.park(otherCar);

        Car pickedCar = parkingLot.pickCar(myTicket);

        assertEquals(myCar, pickedCar);
    }

    @Test
    void shouldFailedPickingGivenInvalidTicketFromParkingLotWhereMyCarParked(){
        Car myCar = new Car("A11111");
        ParkingLot parkingLot = new ParkingLot(2, "A");

        Ticket myTicket = parkingLot.park(myCar);
        Ticket invalidTicket = new Ticket("Invalid", "WrongNumber");

        assertNull(parkingLot.pickCar(invalidTicket));
    }

    @Test
    void shouldFailedTheSecondTimePickingCarGivenSameTicket(){
        Car myCar = new Car("A11111");
        ParkingLot parkingLot = new ParkingLot(2, "A");

        Ticket myTicket = parkingLot.park(myCar);
        Car pickedCar = parkingLot.pickCar(myTicket);
        Car secondPickedCar = parkingLot.pickCar(myTicket);

        assertNull(secondPickedCar);
    }
}
