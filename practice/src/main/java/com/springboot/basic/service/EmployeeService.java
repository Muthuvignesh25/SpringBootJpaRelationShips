package com.springboot.basic.service;

import com.springboot.basic.exception.EmployeeException;
import com.springboot.basic.model.Employee;

import java.util.List;

public interface EmployeeService {
    public Employee save(Employee employee);
    public List<Employee> getAllEmployees();
    public Employee getEmployeeById(int id) throws EmployeeException,Exception;
    public String deleteEmployeeById(int id);

    Employee getEmployeeByName(String name);
}
