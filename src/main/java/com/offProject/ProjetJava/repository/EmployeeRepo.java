package com.offProject.ProjetJava.repository;

import com.offProject.ProjetJava.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee, Integer> {


    @Query("SELECT e  FROM  Employee e WHERE e.firstname = :employeefirstname AND e.lastname = :employeelastname ")
    Optional<Employee> findEmployeeWithfirst_name(String employeefirstname, String employeelastname);
}
