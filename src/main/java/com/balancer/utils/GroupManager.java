package com.balancer.utils;

import com.balancer.handler.UserIdValidationException;

import java.util.Random;

public class GroupManager {

    private final static String[] groups = {"groupA", "groupB", "groupC"};


    public String getGroup(String userId) throws  UserIdValidationException{

        if(userId == null) {
            throw new UserIdValidationException("User id is empty");
        }

        if(!IdValidator.validateId(userId)) {
            throw new UserIdValidationException("User id " + userId + " contains non alpha-numerical characters");
        }

        return groups[new Random().nextInt(groups.length)];

    }
}
