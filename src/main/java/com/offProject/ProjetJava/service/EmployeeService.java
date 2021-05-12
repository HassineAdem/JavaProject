package com.offProject.ProjetJava.service;

import com.offProject.ProjetJava.exception.EmployeeException;
import com.offProject.ProjetJava.model.Employee;
import com.offProject.ProjetJava.repository.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepo employeeRepo;


    public List<Employee> getAllEmployee() {
        return employeeRepo.findAll();
    }


    public Employee getEmployeeById(Integer id) {
        Optional<Employee> employeeOptional = employeeRepo.findById(id);
        Employee employee = employeeOptional.get();
        return employee;
    }

    public void deleteEmployee(Integer id) {
        employeeRepo.deleteById(id);
    }

    public void saveEmployee(Employee employee) {
        if (Employeeispresent(employee))
            throw new EmployeeException("Employée déja ajouté");
        employeeRepo.save(employee);
    }


    public void updateEmployee(Employee currentEmployee, Integer id) {
        Optional<Employee> employeeOptional = employeeRepo.findById(id);
        if (employeeOptional.isPresent()) {
            Employee employee = employeeOptional.get();


            employee.setFirstname(currentEmployee.getFirstname());
            employee.setLastname(currentEmployee.getLastname());
            employee.setEmail(currentEmployee.getEmail());
            employeeRepo.save(employee);
        }
    }

    public boolean Employeeispresent(Employee employee) {
        Optional<Employee> employeeOptional = employeeRepo.findEmployeeWithfirst_name(employee.getFirstname(), employee.getLastname());
        return employeeOptional.isPresent();
    }
}
