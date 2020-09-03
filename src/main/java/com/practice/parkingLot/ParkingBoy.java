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
        int maxVacancyRateIndex = 0;
        for (ParkingLot parkingLot: parkingLots){
            if(getVacancyRate(parkingLot)>getVacancyRate(parkingLots.get(maxVacancyRateIndex))){
                maxVacancyRateIndex = parkingLots.indexOf(parkingLot);
            }
        }
        if(parkingLots.get(maxVacancyRateIndex).emptyParkingList.size()>0){
            return parkingLots.get(maxVacancyRateIndex).park(car);
        } else {
            return new Ticket(message.fullMessage, car.getNumber());
        }
    }
    
    public Car pickUp(Ticket ticket){
        if(ticket.getParkingSpotId().split(":").length!=2){
            return null;
        }
        for (ParkingLot parkingLot: parkingLots){
            if(ticket.getParkingSpotId().split(":")[0].equals(parkingLot.name)){
                return parkingLot.pickCar(ticket);
            }
        }
        return null;
    }

    private float getVacancyRate(ParkingLot parkingLot){
        int totalNumberOfParkingSpots = parkingLot.emptyParkingList.size()+parkingLot.parkedParkingList.size();
        int numberOfEmptyParkingSpots = parkingLot.emptyParkingList.size();
        return (float) numberOfEmptyParkingSpots/totalNumberOfParkingSpots;
    }
}
