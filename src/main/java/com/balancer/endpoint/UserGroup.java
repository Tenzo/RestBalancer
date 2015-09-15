package com.balancer.endpoint;

import com.balancer.handler.UserIdValidationException;
import com.balancer.utils.GroupManager;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/group")
public class UserGroup {
    private final GroupManager groupManager = new GroupManager();
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public Response getTestGroup(@QueryParam("userId") String userId) throws UserIdValidationException {

        String group = groupManager.getGroup(userId);
        return Response.status(200).entity(group).build();
    }
}
