package com.balancer.configuration;


import org.yaml.snakeyaml.Yaml;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ConfigReader {

    private ConfigReader() {}

    public static GroupsConfiguration read(String path) {
        Yaml yaml = new Yaml();
        try {
            InputStream in = Files.newInputStream(Paths.get(path));
            return yaml.loadAs(in, GroupsConfiguration.class);
        }
        catch (IOException e) {
            throw new RuntimeException("O LOL NIE MA CONFIGU");
        }
    }
}
