package com.springboot.basic.exception;

import com.springboot.basic.entity.EmployeeErrorMessage;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class EmployeeExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(EmployeeException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public  EmployeeErrorMessage errorMessage(EmployeeException e){
        EmployeeErrorMessage err=  new EmployeeErrorMessage(HttpStatus.NOT_FOUND,e.getMessage());
        return err;
    }
}
