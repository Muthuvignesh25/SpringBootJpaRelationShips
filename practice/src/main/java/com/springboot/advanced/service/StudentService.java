package com.springboot.advanced.service;

import com.springboot.advanced.entity.Course;
import com.springboot.advanced.entity.Student;
import com.springboot.advanced.entity.Subject;
import com.springboot.advanced.model.Response;
import com.springboot.advanced.model.StudentRequest;
import com.springboot.advanced.model.StudentResponse;
import com.springboot.advanced.model.SubjectRequest;
import com.springboot.advanced.repository.CourseRepository;
import com.springboot.advanced.repository.StudentRepository;
import com.springboot.advanced.repository.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private CourseRepository courseRepository;
    @Autowired
    private SubjectRepository subjectRepository;
    public Response saveStudent(StudentRequest studentRequest) {
        Student student=new Student();
        student.setName(studentRequest.getName());
        student.setAge(studentRequest.getAge());
        student=studentRepository.save(student);
        Course course=new Course();
        course.setCourseName(studentRequest.getCourseName());
        course.setYear(studentRequest.getYear());
        course.setStudent(student);
        course=courseRepository.save(course);
        List<Subject> subjects=new ArrayList<>();
        for(SubjectRequest subjectRequest:studentRequest.getSubjects()){
            Subject subject=new Subject();
            subject.setName(subjectRequest.getSubjectName());
            subject.setMark(subjectRequest.getMark());
            subject.setCourse(course);
            subjects.add(subject);
        }
        subjects=subjectRepository.saveAll(subjects);
        course.setSubject(subjects);
//        return new StudentResponse(course);
        student.setCourse(course);
        return new Response(student);
    }

    public List<StudentResponse> getAllStudents() {
        List<Course> courses=courseRepository.findAll();
        List<StudentResponse> studentResponses=new ArrayList<>();
        for(Course course:courses){
            studentResponses.add(new StudentResponse(course));
        }
        return studentResponses;
    }
}
