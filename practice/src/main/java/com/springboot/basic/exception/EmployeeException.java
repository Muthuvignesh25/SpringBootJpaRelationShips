package com.springboot.basic.exception;

public class EmployeeException extends RuntimeException {
    public EmployeeException(String message) {
        super(message);
    }
    public EmployeeException() {
    }
}
