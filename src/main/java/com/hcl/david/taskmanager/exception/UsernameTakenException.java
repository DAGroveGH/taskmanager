package com.hcl.david.taskmanager.exception;

public class UsernameTakenException extends RuntimeException {
    public UsernameTakenException(String username) {
        super(username + " is already taken");
    }
}