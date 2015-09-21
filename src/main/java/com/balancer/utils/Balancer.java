package com.balancer.utils;

import com.balancer.configuration.GroupsConfiguration;
import com.balancer.model.UsersRepository;

import javax.ws.rs.core.Response;
import java.util.Optional;
import java.util.stream.Collectors;

public class Balancer {

    private GroupsConfiguration config;
    private UsersRepository repository;

    public Balancer(GroupsConfiguration config) {
        this.config = config;
        this.repository = new UsersRepository(config.getGroups());
    }

    public Response getGroupForUser(String userId) {
        Optional<String> userGroup = repository.getUserGroup(userId);
        if(userGroup.isPresent()) {
            return Response.status(Response.Status.OK)
                    .entity(userGroup.get())
                    .build();
        }
        else {
            return Response.status(Response.Status.CREATED)
                    .entity(getBalancedGroup(userId))
                    .build();
        }
    }

    private String getBalancedGroup(String userId) {
        return config.getBalance().entrySet().stream().collect(Collectors.toMap(
                entry -> entry.getKey(),
                entry -> entry.getValue() - repository.getCurrentBalance().get(entry.getKey())
                )).entrySet()
                    .stream()
                    .max((e1, e2) -> Double.compare((Double)e1.getValue(), (Double)e2.getValue()))
                    .get()
                    .getKey();
    }
}
