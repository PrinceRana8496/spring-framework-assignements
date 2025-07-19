package com.prince.springproject2.service;

import com.prince.springproject2.model.Employee;
import com.prince.springproject2.repo.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
    private EmployeeRepo repo;
    public EmployeeRepo getRepository() {
        return repo;
    }
    @Autowired
    public void setRepository(EmployeeRepo repo) {
        this.repo = repo;
    }

    public  void  addEmployee(Employee s)
    {
        repo.save(s);
    }

    public List<Employee> getEmployee() {
        return repo.findAll();
    }
}
