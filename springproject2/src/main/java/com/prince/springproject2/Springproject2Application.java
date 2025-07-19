package com.prince.springproject2;

import com.prince.springproject2.model.Employee;
import com.prince.springproject2.service.EmployeeService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.List;
@SpringBootApplication
public class Springproject2Application {
	public static void main(String[] args) {
		ApplicationContext context=SpringApplication.run(Springproject2Application.class, args);
		Employee s=context.getBean(Employee.class);
		Employee s1=context.getBean(Employee.class);
		s.setName("Prince");
		s.setDesignation("Trainee");
		s.setId(104);
		s.setName("Amit");
		s.setDesignation("Trainee");
		s.setId(105);
		EmployeeService service=context.getBean(EmployeeService.class);
		service.addEmployee(s);
		service.addEmployee(s1);
		List<Employee> employees=service.getEmployee();
		System.out.println(employees);
	}

}
