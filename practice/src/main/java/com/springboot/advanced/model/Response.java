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
public class Response {
    private Long studentId;
    private String name;
    private int age;
    private String courseName;
    private int year;
    private Long courseId;
    private List<SubjectResponse> subjects=new ArrayList<>();
    public Response(Student student){
        this.courseName=student.getCourse().getCourseName();
        this.year=student.getCourse().getYear();
        this.studentId=student.getId();
        this.name=student.getName();
        this.age=student.getAge();
        this.courseId=student.getCourse().getId();
        for(Subject subject:student.getCourse().getSubject()){
            this.subjects.add(new SubjectResponse(subject));
        }
    }
}
