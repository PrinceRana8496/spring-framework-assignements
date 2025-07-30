package com.prince.Springdatajpa2.service;

import com.prince.Springdatajpa2.dto.EmployeeBasicInfoDTO;
import com.prince.Springdatajpa2.dto.EmployeeNameDTO;
import com.prince.Springdatajpa2.entity.Employee;
import com.prince.Springdatajpa2.repository.EmployeeRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl {

    private final EmployeeRepository repository;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository repository) {
        this.repository = repository;
    }

    public void deleteEmployeeWithagegreater(int age)
    {
        repository.deleteEmployeeWithAgeGreaterThen(age);
    }


    public void deleteEmployeesWithMinimumSalary() {
        Double minSalary = repository.getMinimumSalary();
        repository.deleteEmployeesWithMinSalary(minSalary);

    }
    public List<EmployeeBasicInfoDTO> getEmployeesEndingWithSingh() {
        return repository.findEmployeesByLastNameEndingWith("%Singh");
    }

//    public int updateSalariesBelowAverage(double newSalary) {
//        return repository.query2(newSalary);
//    }
@Transactional
public void updateSalariesBelowAverage(double newSalary) {
    Double avgSalary = repository.getAverageSalary();
    repository.query2(newSalary, avgSalary);
}

    public List<EmployeeNameDTO> getEmployeesWithSalaryAboveAverage() {
        return repository.findQuery1();
    }

    public Employee createEmployee(Employee employee) {
        return repository.save(employee);
    }


    public Employee updateEmployee(Long id, Employee updatedEmployee) {
        Optional<Employee> optionalEmployee = repository.findById(id);
        if (optionalEmployee.isPresent()) {
            Employee existing = optionalEmployee.get();
            existing.setFirstName(updatedEmployee.getFirstName());
            existing.setLastName(updatedEmployee.getLastName());
            existing.setAge(updatedEmployee.getAge());
            existing.setSalary(updatedEmployee.getSalary());
            return repository.save(existing);
        }
        throw new RuntimeException("Employee not found with ID: " + id);
    }

    public void deleteEmployee(Long id) {
        repository.deleteById(id);
    }

    public Employee getEmployeeById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee not found with ID: " + id));
    }

    public List<Employee> getAllEmployees() {
        return repository.findAll();
    }




}
