package com.practice.parkingLot;

import java.util.ArrayList;

public class ParkingLot {
    private ArrayList<String> emptyParkingList = new ArrayList<>();
    private ArrayList<String> parkedParkingList = new ArrayList<>();

    public ParkingLot(){
        this.emptyParkingList.add("A1");
    }

    public Ticket park(Car car){
        String parkingPlace = emptyParkingList.get(0);
        parkedParkingList.add(parkingPlace);
        emptyParkingList.remove(0);
        return new Ticket(parkingPlace, car);
    }
}
