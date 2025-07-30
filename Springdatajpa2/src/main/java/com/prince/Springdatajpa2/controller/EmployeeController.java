package com.prince.Springdatajpa2.controller;

import com.prince.Springdatajpa2.dto.EmployeeBasicInfoDTO;
import com.prince.Springdatajpa2.dto.EmployeeNameDTO;
import com.prince.Springdatajpa2.entity.Employee;
import com.prince.Springdatajpa2.service.EmployeeServiceImpl;
import jakarta.transaction.Transactional;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    private final EmployeeServiceImpl service;

    public EmployeeController(EmployeeServiceImpl service) {
        this.service = service;
    }

    @DeleteMapping("/delete-emp-with-age")
    public ResponseEntity<String> deleteempwithage(@RequestParam int age) {
        service.deleteEmployeeWithagegreater(age);
        return ResponseEntity.ok("Employees with age greater than 45 is deleted.");
    }

    @GetMapping("/lastname-ending-with-singh")
    public ResponseEntity<List<EmployeeBasicInfoDTO>> getEmployeesEndingWithSingh() {
        return ResponseEntity.ok(service.getEmployeesEndingWithSingh());
    }
    @DeleteMapping("/delete-min-salary-employees")
    public ResponseEntity<String> deleteMinSalaryEmployees() {
        service.deleteEmployeesWithMinimumSalary();
        return ResponseEntity.ok("Employees with minimum salary deleted.");
    }
    @PutMapping("/update-salary-below-average")
    public ResponseEntity<String> updateSalaries(@RequestParam double newSalary) {
        service.updateSalariesBelowAverage(newSalary);
        return ResponseEntity.ok( " employees updated");
    }
    @GetMapping("/above-average-salary")
    public ResponseEntity<List<EmployeeNameDTO>> getAboveAverageSalaryEmployees() {
        return ResponseEntity.ok(service.getEmployeesWithSalaryAboveAverage());
    }
    @PostMapping
    public ResponseEntity<Employee> create(@RequestBody Employee employee) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.createEmployee(employee));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Employee> update(@PathVariable Long id, @RequestBody Employee employee) {
        return ResponseEntity.ok(service.updateEmployee(id, employee));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        service.deleteEmployee(id);
        return ResponseEntity.ok("Employee deleted successfully");
    }

    @GetMapping("/{id}")
    public ResponseEntity<Employee> get(@PathVariable Long id) {
        return ResponseEntity.ok(service.getEmployeeById(id));
    }

    @GetMapping
    public ResponseEntity<List<Employee>> getAll() {
        return ResponseEntity.ok(service.getAllEmployees());
    }

}
