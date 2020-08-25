package com.practice.parkingLot;

public class Ticket {
    private String parkingPlace;
    private Car parkedCar;

    public Ticket(String parkingPlace, Car car) {
        this.parkingPlace = parkingPlace;
        this.parkedCar = car;
    }

    public String getParkingPlace() {
        return this.parkingPlace;
    }

    public Car getParkedCar() {
        return this.parkedCar;
    }

    @Override
    public String toString() {
        return "Car" + this.parkedCar.getNumber() + "parked at" + this.parkingPlace;
    }
}
