package com.balancer.utils;

import com.balancer.handler.UserIdValidationException;

import java.util.Random;

public class Balancer {

    private final static String[] groups = {"groupA", "groupB", "groupC"};

    public String getGroup(String userId){

        if(userId == null) {
            throw new UserIdValidationException("User id is empty");
        }

        if(!IdValidator.validateId(userId)) {
            throw new UserIdValidationException("User id " + userId + " contains non alpha-numerical characters");
        }

        return groups[new Random().nextInt(groups.length)];

    }
}
