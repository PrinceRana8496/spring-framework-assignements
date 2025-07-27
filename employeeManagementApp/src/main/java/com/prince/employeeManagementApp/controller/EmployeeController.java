package com.prince.employeeManagementApp.controller;


import com.prince.employeeManagementApp.entity.Employee;
import com.prince.employeeManagementApp.service.EmployeeService;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    private final EmployeeService service;

    public EmployeeController(EmployeeService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Employee> create(@RequestBody Employee employee) {
        return ResponseEntity.ok(service.createEmployee(employee));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Employee> update(@PathVariable Long id, @RequestBody Employee employee) {
        return ResponseEntity.ok(service.updateEmployee(id, employee));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        service.deleteEmployee(id);
        return ResponseEntity.ok("Employee deleted");
    }

    @GetMapping("/{id}")
    public ResponseEntity<Employee> get(@PathVariable Long id) {
        return ResponseEntity.ok(service.getEmployeeById(id));
    }

    @GetMapping
    public ResponseEntity<List<Employee>> getAll() {
        return new ResponseEntity<>(service.getAllEmployees(),HttpStatus.OK);
    }
    @GetMapping("/count")
    public ResponseEntity<Long> getEmployeeCount() {
        return ResponseEntity.ok(service.getEmployeeCount());
    }
    @GetMapping("/paged")
    public ResponseEntity<List<Employee>> getEmployeesPaginated(
            @RequestParam int page,
            @RequestParam int size)  {

        Page<Employee> pagedResult = service.getEmployeesByAgePaginated(page, size);
        return ResponseEntity.ok(pagedResult.getContent());
    }
    @GetMapping("/by-name/{name}")
    public ResponseEntity<List<Employee>> getEmpByName(@PathVariable String name)
    {
        return ResponseEntity.ok(service.getEmployeeByName(name));
    }
    @GetMapping("/by-firstChar/{prefix}")
    public ResponseEntity<List<Employee>> getEmplByFirstChar(@PathVariable String prefix)
    {
        return ResponseEntity.ok(service.getEmployeeByNameFirstCharacter(prefix));
    }
    @GetMapping("/agebetween")
    public ResponseEntity<List<Employee>> getEmployeesBwAge(
            @RequestParam int age1,
            @RequestParam int age2)  {

       return ResponseEntity.ok(service.getEmployeeByAgeBetween(age1,age2));
    }

}
