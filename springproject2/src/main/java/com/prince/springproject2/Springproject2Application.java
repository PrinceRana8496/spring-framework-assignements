package com.prince.springproject2;

import com.prince.springproject2.model.BookStore;
import com.prince.springproject2.model.Employee;
import com.prince.springproject2.service.EmployeeService;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationContext;
import org.springframework.context.event.EventListener;

import java.util.List;
@SpringBootApplication
public class Springproject2Application {
	@Autowired
	private BookStore bookStore;

	public static void main(String[] args) {
		SpringApplication.run(Springproject2Application.class, args);

	}

	@PostConstruct
	public void showBookDetails() {
		System.out.println(bookStore);




//		ApplicationContext context=SpringApplication.run(Springproject2Application.class, args);
//		Employee s=context.getBean(Employee.class);
//		Employee s1=context.getBean(Employee.class);
//		s.setName("Prince");
//		s.setDesignation("Trainee");
//		s.setId(104);
//		s.setName("Amit");
//		s.setDesignation("Trainee");
//		s.setId(105);
//		EmployeeService service=context.getBean(EmployeeService.class);
//		service.addEmployee(s);
//		service.addEmployee(s1);
//		List<Employee> employees=service.getEmployee();
//		System.out.println(employees);
	}

}
