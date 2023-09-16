package com.springboot.basic.exception;

import com.springboot.basic.entity.EmployeeErrorMessage;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GenericException {

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public EmployeeErrorMessage errorMessage(Exception e){
        return new EmployeeErrorMessage(HttpStatus.INTERNAL_SERVER_ERROR,e.getMessage());
    }
}


