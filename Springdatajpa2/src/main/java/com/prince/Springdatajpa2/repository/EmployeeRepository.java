package com.prince.Springdatajpa2.repository;

import com.prince.Springdatajpa2.dto.EmployeeBasicInfoDTO;
import com.prince.Springdatajpa2.dto.EmployeeNameDTO;
import com.prince.Springdatajpa2.entity.Employee;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee,Long> {

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM employee WHERE emp_age >:age", nativeQuery = true)
    void deleteEmployeeWithAgeGreaterThen(@Param("age") int age);

    @Query(value = "SELECT emp_id, emp_first_name, emp_age FROM employee"+
            "WHERE emp_last_name LIKE :suffix", nativeQuery = true)
    List<EmployeeBasicInfoDTO> findEmployeesByLastNameEndingWith(@Param("suffix") String suffix);


    @Query("SELECT MIN(e.salary) FROM Employee e")
    Double getMinimumSalary();

    @Modifying
    @Transactional
    @Query("DELETE FROM Employee e WHERE e.salary = :minSalary")
    void deleteEmployeesWithMinSalary(@Param("minSalary") double minSalary);


    @Query("SELECT e.firstName, e.lastName " +
            "FROM Employee e " +
            "WHERE e.salary > (SELECT AVG(e2.salary) FROM Employee e2) " +
            "ORDER BY e.age ASC, e.salary DESC")
    List<EmployeeNameDTO> findQuery1();


    @Query("SELECT AVG(e.salary) FROM Employee e")
    Double getAverageSalary();
    @Modifying
    @Query("UPDATE Employee e SET e.salary = :newSalary WHERE e.salary < :avgSalary")
    void query2(@Param("newSalary") double newSalary, @Param("avgSalary") double avgSalary);
}
