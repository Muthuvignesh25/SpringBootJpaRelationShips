package com.springboot.advanced.model;

import com.springboot.advanced.entity.Subject;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SubjectResponse {
    private Long id;
    private String subjectName;
    private int mark;

    public SubjectResponse(Subject subject){
        this.id=subject.getId();
        this.subjectName=subject.getName();
        this.mark=subject.getMark();
    }
}

