package com.balancer.handler;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class UserIdValidationExceptionMapper implements ExceptionMapper<UserIdValidationException> {
        public Response toResponse(UserIdValidationException ex) {
            return Response.status(Response.Status.BAD_REQUEST).
                    entity(ex.getMessage()).
                    type("text/plain").
                    build();
        }
}
