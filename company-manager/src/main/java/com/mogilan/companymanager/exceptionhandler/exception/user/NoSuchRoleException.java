package com.mogilan.companymanager.exceptionhandler.exception.user;

public class NoSuchRoleException extends RuntimeException{

    public NoSuchRoleException(String name) {
        super("Sorry, role \"" + name + "\" not found");
    }
}
