package com.practice.parkingLot;

import com.practice.parkingLot.common.Message;

import java.util.ArrayList;

public class ParkingBoy {
    private ArrayList<ParkingLot> parkingLots;
    private Message message = new Message();
    
    public ParkingBoy(ArrayList<ParkingLot> parkingLots){
        this.parkingLots = parkingLots;
    }
    
    public Ticket park(Car car){
        for (ParkingLot parkingLot: parkingLots){
            if(parkingLot.emptyParkingList.size()>0){
                return parkingLot.park(car);
            }
        }
        return new Ticket(message.fullMessage, car.getNumber());
    }
    
    public Car pickUp(Ticket ticket){
        String parkingSpotId = ticket.getParkingPlace();
        for (ParkingLot parkingLot: parkingLots){
            for (ParkingSpot parkingSpot: parkingLot.parkedParkingList){
                if(parkingSpot.id.equals(parkingSpotId)){
                    return parkingLot.pickCar(ticket);
                }
            }
        }
        return null;
    }
}
