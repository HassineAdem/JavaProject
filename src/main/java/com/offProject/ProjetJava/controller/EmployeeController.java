package com.offProject.ProjetJava.controller;

import com.offProject.ProjetJava.model.Employee;
import com.offProject.ProjetJava.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/employee")
@RestController
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @PostMapping
    public void saveEmployee(@RequestBody Employee employee) {
        employeeService.saveEmployee(employee);
    }

    @GetMapping
    public List<Employee> getAllEmployee() {
        return employeeService.getAllEmployee();
    }

    @DeleteMapping("/delete")
    public void deleteEmployee(@RequestParam(value = "id") Integer id) {
        employeeService.deleteEmployee(id);
    }

    @RequestMapping("/search")
    public Employee getEmlpoyeeById(@RequestParam(value = "id") Integer id) {
        return employeeService.getEmployeeById(id);
    }

    @PutMapping("/update")
    public void updateEmployee(@RequestBody Employee employee, @RequestParam(value = "id") Integer id) {
        employeeService.updateEmployee(employee, id);
    }
}
