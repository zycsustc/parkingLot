package com.practice.parkingLot;

public class Ticket {
    private String parkingSpotId;
    private String carNumber;

    public Ticket(String parkingSpotId, String carNumber) {
        this.parkingSpotId = parkingSpotId;
        this.carNumber = carNumber;
    }

    public String getParkingSpotId() {
        return this.parkingSpotId;
    }

    public String getCarNumber() {
        return this.carNumber;
    }

    @Override
    public String toString() {
        return "Car " + this.carNumber + " parked at " + this.parkingSpotId;
    }
}
