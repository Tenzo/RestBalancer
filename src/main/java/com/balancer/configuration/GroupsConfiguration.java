package com.balancer.configuration;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class GroupsConfiguration {

    private final static String CONFIG_PATH = "/usr/home/jeedeye/IdeaProjects/RestBalancer/config/configuration.yml";
    private Map<String, Double> groups;

    public GroupsConfiguration() {
        groups = new HashMap<>();
    }

    public Map<String, Double> getGroups() {
        return groups;
    }

    public void setGroups(Map<String, Double> groups) {
        this.groups = groups;
    }

    public Map<String, Double> getBalance() {
        return groups.entrySet()
                .stream()
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                    entry -> (entry.getValue() / getWeightsSum())
                ));
    }

    private Double getWeightsSum() {
        return groups.entrySet()
                .stream()
                .mapToDouble(Map.Entry::getValue)
                .sum();
    }
}
