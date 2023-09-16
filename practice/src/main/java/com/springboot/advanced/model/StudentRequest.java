package com.springboot.advanced.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class StudentRequest {
    private String name;
    private int age;
    private String courseName;
    private int year;
    private List<SubjectRequest> subjects;
}
