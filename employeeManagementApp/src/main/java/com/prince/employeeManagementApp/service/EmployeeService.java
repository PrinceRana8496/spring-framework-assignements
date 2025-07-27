package com.prince.employeeManagementApp.service;

import com.prince.employeeManagementApp.entity.Employee;
import org.springframework.data.domain.Page;

import java.util.List;

public interface EmployeeService {
    Employee createEmployee(Employee employee);
    Employee updateEmployee(Long id, Employee employee);
    void deleteEmployee(Long id);
    Employee getEmployeeById(Long id);
    List<Employee> getAllEmployees();
    long getEmployeeCount();
    Page<Employee> getEmployeesByAgePaginated(int page, int size);
    List<Employee> getEmployeeByName(String name);
    List<Employee> getEmployeeByNameFirstCharacter(String prefix);
    List<Employee> getEmployeeByAgeBetween(int age1,int age2);

}
