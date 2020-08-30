package com.practice.parkingLot;

import com.practice.parkingLot.common.Message;

import java.util.ArrayList;

public class ParkingLot {
    public ArrayList<ParkingSpot> emptyParkingList = new ArrayList<>();
    public ArrayList<ParkingSpot> parkedParkingList = new ArrayList<>();
    private Message message = new Message();

    public ParkingLot(int number){
        for(int i=0;i<number;i++){
            this.emptyParkingList.add(new ParkingSpot("A"+i+1));
        }
    }

    public Ticket park(Car car){
        ParkingSpot parkingSpot;
        if(emptyParkingList.size()>0){
            parkingSpot = emptyParkingList.get(0);
            parkingSpot.parkCar(car);
            parkedParkingList.add(parkingSpot);
            emptyParkingList.remove(0);
        }else {
            parkingSpot = new ParkingSpot(message.fullMessage);
        }
        return new Ticket(parkingSpot.id, car.getNumber());
    }

    public Car pickCar(Ticket ticket){
        String parkingSpotId = ticket.getParkingPlace();
        for(ParkingSpot spot: parkedParkingList){
            if(spot.id.equals(parkingSpotId)){
                if(spot.isParked){
                    return spot.getCar();
                }
            }
        }
        System.out.println("Invalid Ticket!");
        return null;
    }
}
