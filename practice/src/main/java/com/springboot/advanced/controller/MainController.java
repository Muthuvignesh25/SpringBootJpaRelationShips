package com.springboot.advanced.controller;

import com.springboot.advanced.model.Response;
import com.springboot.advanced.model.StudentRequest;
import com.springboot.advanced.model.StudentResponse;
import com.springboot.advanced.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class MainController {

    @Autowired
    private StudentService studentService;
    @PostMapping
    public Response saveStudent(@RequestBody StudentRequest studentRequest){
         return studentService.saveStudent(studentRequest);
    }

    @GetMapping
    public List<StudentResponse> getAllStudents(){
        return studentService.getAllStudents();
    }
}
