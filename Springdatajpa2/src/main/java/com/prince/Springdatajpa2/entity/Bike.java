package com.prince.Springdatajpa2.entity;

import com.prince.Springdatajpa2.repository.BikeRepository;
import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
public class Bike extends Vehicle {
    @Column(columnDefinition = "TINYINT(1)")
    private boolean hasCarrier;
    public Bike(){};

    public Bike(Long id, String brand, boolean hasCarrier) {
        super(id, brand);
        this.hasCarrier = hasCarrier;
    }

    public boolean isHasCarrier() {
        return hasCarrier;
    }

    public void setHasCarrier(boolean hasCarrier) {
        this.hasCarrier = hasCarrier;
    }
}