package com.practice.parkingLot;

import com.practice.parkingLot.common.Message;

import java.util.ArrayList;

public class ParkingLot {
    public String name;
    public ArrayList<ParkingSpot> emptyParkingList = new ArrayList<>();
    public ArrayList<ParkingSpot> parkedParkingList = new ArrayList<>();
    private Message message = new Message();

    public ParkingLot(int number, String name){
        this.name = name;
        for(int i=0;i<number;i++){
            this.emptyParkingList.add(new ParkingSpot(String.valueOf(i)));
        }
    }

    public Ticket park(Car car){
        ParkingSpot parkingSpot;
        if(emptyParkingList.size()>0){
            parkingSpot = emptyParkingList.get(0);
            parkingSpot.parkCar(car);
            parkedParkingList.add(parkingSpot);
            emptyParkingList.remove(0);
            return new Ticket(this.name+":"+parkingSpot.id, car.getNumber());
        }else {
            return new Ticket(message.fullMessage, car.getNumber());
        }
    }

    public Car pickCar(Ticket ticket){
        if(ticket.getParkingSpotId().split(":").length!=2){
            System.out.println("Invalid Ticket!");
            return null;
        }
        String parkingSpotId = ticket.getParkingSpotId().split(":")[1];
        for(ParkingSpot spot: parkedParkingList){
            if(spot.id.equals(parkingSpotId)){
                if(spot.isParked && spot.getCarNumber().equals(ticket.getCarNumber())){
                    return spot.getCar();
                } else {
                    System.out.println("No car parked at the spot!");
                }
            }
        }
        System.out.println("Invalid Ticket!");
        return null;
    }
}
