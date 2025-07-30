package com.prince.Springdatajpa2.repository;

import com.prince.Springdatajpa2.entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepository extends JpaRepository<Car,Long> {
}
