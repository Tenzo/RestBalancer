package com.balancer.endpoint;

import com.balancer.utils.Balancer;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@Path("/group")
public class UserGroup {
    private final Balancer balancer = new Balancer();
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getTestGroup(@QueryParam("step") String userId) {

        return balancer.getGroup(userId);
    }
}
