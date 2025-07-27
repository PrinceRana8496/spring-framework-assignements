package com.prince.employeeManagementApp.repository;

import com.prince.employeeManagementApp.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee,Long> {
    List<Employee> findByName(String name);
    List<Employee> findByNameStartingWith(String first);
    List<Employee> findByAgeBetween(int age1,int age2);
}
