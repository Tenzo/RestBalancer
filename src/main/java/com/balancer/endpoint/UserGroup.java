package com.balancer.endpoint;

import com.balancer.handler.UserIdValidationException;
import com.balancer.utils.GroupManager;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/")
public class UserGroup {
    private static GroupManager groupManager = new GroupManager();
    @GET
    @Path("/group")
    @Produces(MediaType.TEXT_PLAIN)
    public Response getTestGroup(@QueryParam("userId") String userId) throws UserIdValidationException {
        return groupManager.getGroup(userId);
    }
    @GET
    @Path("/all")
    @Produces(MediaType.TEXT_PLAIN)
    public Response getAllGroups() {
        return groupManager.getAllGroups();
    }
}
