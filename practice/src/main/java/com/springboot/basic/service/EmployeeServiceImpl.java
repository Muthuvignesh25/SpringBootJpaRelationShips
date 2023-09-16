package com.springboot.basic.service;

import com.springboot.basic.entity.EmployeeEntity;
import com.springboot.basic.exception.EmployeeException;
import com.springboot.basic.model.Employee;
import com.springboot.basic.repository.EmployeeRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    @Autowired
    private EmployeeRepository employeeRepository;
    @Override
    public Employee save(Employee employee) {
        EmployeeEntity employeeEntityObject=new EmployeeEntity();
        BeanUtils.copyProperties(employee,employeeEntityObject);
        employeeEntityObject=employeeRepository.save(employeeEntityObject);
        employee.setId(employeeEntityObject.getId());
        return employee;
    }

    @Override
    public List<Employee> getAllEmployees() {
        List<EmployeeEntity> ee=employeeRepository.findAll();
        List<Employee> employees=new ArrayList<>();
        for(EmployeeEntity e:ee){
            Employee emp=new Employee();
            BeanUtils.copyProperties(e,emp);
            employees.add(emp);
        }
        return employees;
    }

    @Override
    public Employee getEmployeeById(int id) throws EmployeeException,Exception {
        try {
            EmployeeEntity emp = employeeRepository.findById(id).orElseThrow(() -> new EmployeeException("Employee Not Found"));
            Employee employee = new Employee();
            BeanUtils.copyProperties(emp, employee);
            return employee;
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public String deleteEmployeeById(int id) {
        employeeRepository.deleteById(id);
        return "Employee Deleted Successfully";
    }

    public Employee getEmployeeByName(String name){
        EmployeeEntity ee=employeeRepository.findByName(name);
        System.out.println(ee.getName());
        Employee emp=new Employee();
        BeanUtils.copyProperties(ee,emp);
        return emp;
    }
}