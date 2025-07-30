package com.prince.Springdatajpa2.repository;

import com.prince.Springdatajpa2.entity.Employee;
import com.prince.Springdatajpa2.entity.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VehicleRepository extends JpaRepository<Vehicle,Long> {
}
