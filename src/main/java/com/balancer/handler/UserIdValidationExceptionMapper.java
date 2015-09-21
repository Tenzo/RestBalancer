package com.balancer.handler;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class UserIdValidationExceptionMapper implements ExceptionMapper<UserIdValidationException> {

    @Override
    public Response toResponse(UserIdValidationException ex) {

        return Response.status(422).
                entity(ex.getMessage()).
                type("text/plain").
                build();
    }
}
