package com.prince.spring_rest.service;

import com.prince.spring_rest.modal.Employee;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class EmployeeService {

    private Map<Integer, Employee> employeeMap = new HashMap<>();

    // Add employee
    public void addEmployee(Employee employee) {
        employeeMap.put(employee.getId(), employee);
    }

    // Get all employees
    public List<Employee> getAllEmployees() {
        return new ArrayList<>(employeeMap.values());
    }

    // Get employee by ID
    public Employee getEmployeeById(int id) {
        return employeeMap.get(id);
    }

    // Update employee
    public void updateEmployee(int id, Employee updatedEmployee) {
        if (employeeMap.containsKey(id)) {
            employeeMap.put(id, updatedEmployee);
        }
    }

    // Delete employee
    public void deleteEmployee(int id) {
        employeeMap.remove(id);
    }

}
