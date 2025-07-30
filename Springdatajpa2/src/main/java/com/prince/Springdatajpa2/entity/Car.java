package com.prince.Springdatajpa2.entity;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
public class Car extends Vehicle {
    private int numberOfDoors;
    public Car(){};
    public Car(Long id, String brand, int numberOfDoors) {
        super(id, brand);
        this.numberOfDoors = numberOfDoors;
    }

    public int getNumberOfDoors() {
        return numberOfDoors;
    }

    public void setNumberOfDoors(int numberOfDoors) {
        this.numberOfDoors = numberOfDoors;
    }
}
