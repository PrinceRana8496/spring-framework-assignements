package com.prince.employeeManagementApp.service;

import com.prince.employeeManagementApp.entity.Employee;
import com.prince.employeeManagementApp.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository repository;
    @Autowired
    public EmployeeServiceImpl(EmployeeRepository repository) {
        this.repository = repository;
    }

    @Override
    public Employee createEmployee(Employee employee) {
        return repository.save(employee);
    }

    @Override
    public Employee updateEmployee(Long id, Employee updatedEmployee) {
        Optional<Employee> optionalEmployee = repository.findById(id);
        if (optionalEmployee.isPresent()) {
            Employee existing = optionalEmployee.get();
            existing.setName(updatedEmployee.getName());
            existing.setAge(updatedEmployee.getAge());
            existing.setLocation(updatedEmployee.getLocation());
            return repository.save(existing);
        }
        throw new RuntimeException("Employee not found with ID: " + id);
    }

    @Override
    public void deleteEmployee(Long id) {
        repository.deleteById(id);
    }

    @Override
    public Employee getEmployeeById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee not found with ID: " + id));
    }

    @Override
    public List<Employee> getAllEmployees() {
        return repository.findAll();
    }

    @Override
    public long getEmployeeCount() {
        return repository.count();
    }

    @Override
    public Page<Employee> getEmployeesByAgePaginated(int page, int size) {
        Sort sort=Sort.by(Sort.Direction.ASC,"age");
        Pageable pageable= PageRequest.of(page,size,sort);
        return repository.findAll(pageable);

    }

    @Override
    public List<Employee> getEmployeeByName(String name) {
        return repository.findByName(name);
    }

    @Override
    public List<Employee> getEmployeeByNameFirstCharacter(String prefix) {
        return repository.findByNameStartingWith(prefix);
    }

    @Override
    public List<Employee> getEmployeeByAgeBetween(int age1, int age2) {
        return repository.findByAgeBetween(age1,age2);
    }
}