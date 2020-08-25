package com.practice.parkingLot;

public class Ticket {
    private String parkingPlace;
    private String carNumber;

    public Ticket(String parkingPlace, String carNumber) {
        this.parkingPlace = parkingPlace;
        this.carNumber = carNumber;
    }

    public String getParkingPlace() {
        return this.parkingPlace;
    }

    public String getCarNumber() {
        return this.carNumber;
    }

    @Override
    public String toString() {
        return "Car" + this.carNumber + "parked at" + this.parkingPlace;
    }
}
