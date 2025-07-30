package com.prince.Springdatajpa2;

import com.prince.Springdatajpa2.entity.Bike;
import com.prince.Springdatajpa2.entity.Car;
import com.prince.Springdatajpa2.entity.Employee1;
import com.prince.Springdatajpa2.entity.Salary;
import com.prince.Springdatajpa2.repository.BikeRepository;
import com.prince.Springdatajpa2.repository.CarRepository;
import com.prince.Springdatajpa2.repository.Employee1Repository;
import com.prince.Springdatajpa2.repository.VehicleRepository;
import jakarta.transaction.Transactional;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Springdatajpa2ApplicationTests {

	@Autowired
	private VehicleRepository vehicleRepository;

	@Autowired
	private CarRepository carRepository;

	@Autowired
	private BikeRepository bikeRepository;

	@Autowired
	private Employee1Repository employee1Repository;

	@Test
	@Transactional
	@Rollback(value = false)
	public void testSaveAndRetrieveVehicles() {
		Car car = new Car();
		car.setBrand("Toyota");
		car.setNumberOfDoors(4);

		Bike bike = new Bike();
		bike.setBrand("Honda");
		bike.setHasCarrier(true);

		vehicleRepository.save(car);
		vehicleRepository.save(bike);
	}

	@Test
	public void testSaveEmployeeWithEmbeddedSalaryDetails() {

		Salary salary = new Salary(50000, 8000, 3000, 4000);

		Employee1 employee = new Employee1("Prince", "Rana", 23, salary);

		Employee1 saved = employee1Repository.save(employee);
	}
}
