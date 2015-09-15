package com.balancer.model;

import java.util.*;

public class UsersRepository {
    private Map<String, List> groups;

    public UsersRepository() {
        groups = new HashMap<>();
    }

    public Optional getUserGroup (String userId) {
        return Optional.ofNullable(groups.entrySet().stream()
                .filter(entry -> entry.getValue().contains(userId))
                .map(entry -> entry.getKey()));
    }

    public void addUserToGroup(String groupName, String userId) {
        if (groups.containsKey(groupName)) {
            groups.get(groupName).add(userId);
        }
    }

    public Map<String, List> getGroups() {
        return groups;
    }
}
