package com.balancer.handler;

public class UserIdValidationException extends RuntimeException {

    public UserIdValidationException() {
        super();
    }

    public UserIdValidationException(String message) {
        super(message);
    }
}
