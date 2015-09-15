package com.balancer.configuration

import org.junit.rules.TemporaryFolder
import spock.lang.Specification

class ConfigReaderTest extends Specification {

    def "should load configuration properly" () {
        given:
        String configYaml = "# Groups for ballancing\n" +
                         "  groups:\n" +
                         "    groupA: 2\n" +
                         "    groupB: 3\n" +
                         "    groupC: 5"
        File tempConfig = File.createTempFile("temp",".yml")
        tempConfig.deleteOnExit()
        tempConfig.write(configYaml)

        ConfigReader configReader = new ConfigReader()

        when:
        GroupsConfiguration configuration = configReader.read(tempConfig.getAbsolutePath())

        then:
        configuration.getGroups().get("groupA") == 2
        configuration.getGroups().get("groupB") == 3
        configuration.getGroups().get("groupC") == 5
    }

    def "should throw exception on invalid yaml file" () {
        given:
        String configYaml = "# Groups for ballancing\n" +
                "  groups:\n" +
                "    groupA: 2\n" +
                "    groupB: 3\n" +
                "    groupC: cos"
        File tempConfig = File.createTempFile("temp",".yml")
        tempConfig.deleteOnExit()
        tempConfig.write(configYaml)

        ConfigReader configReader = new ConfigReader()

        when:
        configReader.read(tempConfig.getAbsolutePath())

        then:
        thrown(Exception)
    }

}
