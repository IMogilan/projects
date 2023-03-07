package com.mogilan.companymanager.exceptionhandler.exception.user;

public class NoSuchUserException extends RuntimeException{

    public NoSuchUserException(String username) {
        super("Sorry, user with username \"" + username + "\" not found");
    }


}
