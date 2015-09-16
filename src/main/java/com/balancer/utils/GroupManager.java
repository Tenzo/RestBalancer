package com.balancer.utils;

import com.balancer.configuration.ConfigReader;
import com.balancer.configuration.GroupsConfiguration;
import com.balancer.handler.UserIdValidationException;

import javax.security.auth.login.Configuration;
import javax.ws.rs.core.Response;
import java.util.Random;

public class GroupManager {

    //private final static String[] groups = {"groupA", "groupB", "groupC"};
    private Balancer balancer;
    private GroupsConfiguration configuration;

    public GroupManager() {
        configuration = ConfigReader.read("config/configuration.yml");
        balancer = new Balancer(configuration);
    }

    public Response getGroup(String userId) throws  UserIdValidationException{

        if(userId == null) {
            throw new UserIdValidationException("User id is empty");
        }

        if(!IdValidator.validateId(userId)) {
            throw new UserIdValidationException("User id " + userId + " contains non alpha-numerical characters");
        }

        return balancer.getGroupForUser(userId);

    }

    public Response getAllGroups() {
        return Response.status(Response.Status.ACCEPTED)
                .entity(configuration.getGroups().keySet().toString())
                .build();
    }
}
