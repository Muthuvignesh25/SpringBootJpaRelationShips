package com.springboot.basic.entity;

import org.springframework.http.HttpStatus;

public class EmployeeErrorMessage {
    private HttpStatus status;
    private String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }

    public EmployeeErrorMessage(HttpStatus status, String message) {
        this.status = status;
        this.message = message;
    }
}
