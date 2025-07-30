package com.prince.Springdatajpa2.repository;

import com.prince.Springdatajpa2.entity.Bike;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BikeRepository extends JpaRepository<Bike,Long> {
}
