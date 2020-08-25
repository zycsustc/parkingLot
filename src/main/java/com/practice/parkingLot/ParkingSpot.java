package com.practice.parkingLot;

public class ParkingSpot {
    public String id;
    public Boolean isParked;
    private Car car;

    public ParkingSpot(String id){
        this.id = id;
        this.isParked = false;
    }

    public String getCarNumber(){
        return this.car.getNumber();
    }

    public void parkCar(Car car){
        this.car = car;
        this.isParked = true;
    }

    public Car getCar() {
        Car pickedCar = this.car;
        emptyCar();
        return pickedCar;
    }

    private void emptyCar(){
        this.car = null;
        this.isParked = false;
    }
}
