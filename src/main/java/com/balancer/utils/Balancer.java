package com.balancer.utils;

import java.util.Random;

public class Balancer {

    private final static String[] groups = {"groupA", "groupB", "groupC"};

    public String getGroup(String userId){
        return groups[new Random().nextInt(groups.length)];
    }
}
