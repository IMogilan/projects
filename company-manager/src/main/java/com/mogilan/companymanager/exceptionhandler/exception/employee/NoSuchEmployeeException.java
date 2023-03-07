package com.mogilan.companymanager.exceptionhandler.exception.employee;

public class NoSuchEmployeeException extends RuntimeException{

    public NoSuchEmployeeException(Long id) {
        super("Sorry, employee with id = " + id + " not found");
    }
}
