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
        int maxEmptyIndex = 0;
        for (ParkingLot parkingLot: parkingLots){
            if(parkingLot.emptyParkingList.size()>parkingLots.get(maxEmptyIndex).emptyParkingList.size()){
                maxEmptyIndex = parkingLots.indexOf(parkingLot);
            }
        }
        if(parkingLots.get(maxEmptyIndex).emptyParkingList.size()>0){
            return parkingLots.get(maxEmptyIndex).park(car);
        } else {
            return new Ticket(message.fullMessage, car.getNumber());
        }
    }
    
    public Car pickUp(Ticket ticket){
        String parkingSpotId = ticket.getParkingSpotId();
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
