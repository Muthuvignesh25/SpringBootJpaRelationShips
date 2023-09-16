package com.springboot.basic.controller;

import com.springboot.basic.exception.EmployeeException;
import com.springboot.basic.model.Employee;
import com.springboot.basic.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping
    public Employee saveEmployee(@RequestBody Employee employee){
        return employeeService.save(employee);
    }

    @GetMapping
    public List<Employee> getAllEmployees(){
        return employeeService.getAllEmployees();
    }

    @GetMapping("/{id}")
    public Employee getEmployeeById(@PathVariable("id") int id) throws EmployeeException,Exception {
        return employeeService.getEmployeeById(id);
    }

    @DeleteMapping("/{id}")
    public String deleteEmployeeById(@PathVariable("id") int id){
        return employeeService.deleteEmployeeById(id);
    }

    @GetMapping("/employee/{name}")
    public Employee getEmployeeByname(@PathVariable("name") String name) {
        return employeeService.getEmployeeByName(name);
    }

}


