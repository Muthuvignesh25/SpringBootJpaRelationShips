package com.springboot.advanced.model;

import com.springboot.advanced.entity.Course;
import com.springboot.advanced.entity.Student;
import com.springboot.advanced.entity.Subject;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class StudentResponse {
    private Long studentId;
    private String name;
    private int age;
    private String courseName;
    private int year;
    private Long courseId;
    private List<SubjectResponse> subjects=new ArrayList<>();
    public StudentResponse(Course course){
        this.courseName=course.getCourseName();
        this.year=course.getYear();
        this.studentId=course.getStudent().getId();
        this.name=course.getStudent().getName();
        this.age=course.getStudent().getAge();
        this.courseId=course.getId();
        System.out.println(course.getSubject());
        for(Subject subject:course.getSubject()){
            this.subjects.add(new SubjectResponse(subject));
        }
    }
}
