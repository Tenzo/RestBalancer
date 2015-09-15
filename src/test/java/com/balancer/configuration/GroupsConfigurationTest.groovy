package com.balancer.configuration

import spock.lang.Specification

class GroupsConfigurationTest extends Specification {

    def "should load configuration" () {
        given:
        def groups = new HashMap<String, Integer> ();
        groups.put("groupA", values[0])
        groups.put("groupB", values[1])
        groups.put("groupC", values[2])

        GroupsConfiguration config = new GroupsConfiguration();
        config.setGroups(groups)

        when:
        Integer weightsSum = config.getWeightsSum()

        then:
        weightsSum == values[0] + values[1] + values[2]

        where:
        ex | values
        1  | [4, 5, 2]
        2  | [5, 7, 8]
        3  | [4, 3 ,2]
    }
}
