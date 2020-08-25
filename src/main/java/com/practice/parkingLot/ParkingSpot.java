package com.practice.parkingLot;

public class ParkingSpot {
    public String id;
    private Car car;

    public ParkingSpot(String id){
        this.id = id;
    }

    public String getCarNumber(){
        return this.car.getNumber();
    }

    public void parkCar(Car car){
        this.car = car;
    }

    public Car getCar() {
        Car pickedCar = this.car;
        emptyCar();
        return pickedCar;
    }

    private void emptyCar(){
        this.car = null;
    }
}
