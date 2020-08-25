package com.practice.parkingLot;

import java.util.ArrayList;

public class ParkingLot {
    private ArrayList<String> emptyParkingList = new ArrayList<>();
    private ArrayList<String> parkedParkingList = new ArrayList<>();
    private Message message = new Message();

    public ParkingLot(int number){
        for(int i=0;i<number;i++){
            this.emptyParkingList.add("A"+i+1);
        }
    }

    public Ticket park(Car car){
        String parkingPlace;
        if(emptyParkingList.size()>0){
            parkingPlace = emptyParkingList.get(0);
            parkedParkingList.add(parkingPlace);
            emptyParkingList.remove(0);
        }else {
            parkingPlace = message.fullMessage;
        }
        return new Ticket(parkingPlace, car);
    }
}
