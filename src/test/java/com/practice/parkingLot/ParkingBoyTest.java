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
        parkingLots.add(new ParkingLot(1));
        ParkingBoy parkingBoy = new ParkingBoy(parkingLots);
        Car firstCar = new Car("A11111");
        Car secondCar = new Car("B11111");
        Ticket ticket = parkingBoy.park(firstCar);
        assertEquals(firstCar, ticket);
        Ticket secondTicket = parkingBoy.park(secondCar);
        assertEquals(secondTicket.getParkingPlace(), message.fullMessage);
    }

    @Test
    void shouldPickUpCarGivenOneParkingLot(){
        ArrayList<ParkingLot> parkingLots = new ArrayList<>();
        parkingLots.add(new ParkingLot(2));
        ParkingBoy parkingBoy = new ParkingBoy(parkingLots);
        Car myCar = new Car("A11111");
        Ticket ticket = parkingBoy.park(myCar);
        Car pickedUpCar = parkingBoy.pickUp(ticket);
        assertEquals(myCar, pickedUpCar);
        Car pickedUpSecondCar = parkingBoy.pickUp(ticket);
        assertEquals(null, pickedUpSecondCar);
    }

}
