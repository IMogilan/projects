package com.mogilan.companymanager.exceptionhandler.handler;

import com.mogilan.companymanager.exceptionhandler.exception.employee.NoSuchEmployeeException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class EmployeeExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<String> noSuchEmployeeExceptionHandler(NoSuchEmployeeException exception) {
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.NOT_FOUND);
    }
}
