package com.prince.Springdatajpa2.service;

import com.prince.Springdatajpa2.dto.EmployeeNameDTO;
import com.prince.Springdatajpa2.entity.Employee;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;

public interface EmployeeService {
    Employee createEmployee(Employee employee);
    Employee updateEmployee(Long id, Employee employee);
    void deleteEmployee(Long id);
    Employee getEmployeeById(Long id);
    List<Employee> getAllEmployees();
    List<EmployeeNameDTO> getEmployeesWithSalaryAboveAverage();
    int updateSalariesBelowAverage();
    void  updateSalariesBelowAverage(double newSalary);

}
