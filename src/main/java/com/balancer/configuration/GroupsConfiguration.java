package com.balancer.configuration;

import org.yaml.snakeyaml.Yaml;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

public class GroupsConfiguration {

    private final static String CONFIG_PATH = "config/configuration.yml";
    private Map<String, Integer> groups;

    public GroupsConfiguration() {

    }

    public Map<String, Integer> getGroups() {
        return groups;
    }

    public void setGroups(Map<String, Integer> groups) {
        this.groups = groups;
    }

    public Integer getWeightsSum() {
        return groups.entrySet()
                .stream()
                .mapToInt(entry -> entry.getValue())
                .sum();
    }
}
