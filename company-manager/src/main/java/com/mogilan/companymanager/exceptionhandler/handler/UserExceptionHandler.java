package com.mogilan.companymanager.exceptionhandler.handler;

import com.mogilan.companymanager.exceptionhandler.exception.user.NoSuchRoleException;
import com.mogilan.companymanager.exceptionhandler.exception.user.NoSuchUserException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class UserExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<String> noSuchRoleExceptionHandler(NoSuchRoleException exception){
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<String> noSuchUserExceptionHandler(NoSuchUserException exception){
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.NOT_FOUND);
    }

}
