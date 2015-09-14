package com.balancer.handler;


import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;

public class UserIdValidationException extends WebApplicationException {

    public UserIdValidationException() {
        super(Response.status(Response.Status.BAD_REQUEST).build());
    }

    public UserIdValidationException(String message) {
        super(Response.status(Response.Status.BAD_REQUEST).
                entity(message).type("text/plain").build());
    }
}
