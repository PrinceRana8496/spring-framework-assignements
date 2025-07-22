package com.prince.spring_rest;

import com.prince.spring_rest.modal.Employee;
import com.prince.spring_rest.service.EmployeeService;
import jakarta.annotation.PostConstruct;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class Controller {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping
    public String addEmployee(@Valid @RequestBody Employee employee) {
        employeeService.addEmployee(employee);
        return "Employee added successfully!";
    }

    @GetMapping
    public List<Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    @GetMapping("/{id}")
    public Employee getEmployeeById(@PathVariable int id) {
        Employee employee= employeeService.getEmployeeById(id);
        if (employee == null) {
            throw new EmployeeNotFoundException("id: " + id);
        }
        return employee;
    }

    @PutMapping("/{id}")
    public String updateEmployee(@PathVariable int id, @RequestBody Employee employee) {
        employeeService.updateEmployee(id, employee);
        return "Employee updated successfully!";
    }

    @DeleteMapping("/{id}")
    public String deleteEmployee(@PathVariable int id) {
        employeeService.deleteEmployee(id);
        return "Employee deleted successfully!";
    }
    @PostConstruct
    public void init() {
        addEmployee(new Employee(1, "Aman", 25));
        addEmployee(new Employee(2, "Prince", 30));
    }
}
