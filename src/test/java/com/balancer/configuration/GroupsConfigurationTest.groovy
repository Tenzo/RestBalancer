package com.balancer.configuration

import spock.lang.Specification


class GroupsConfigurationTest extends Specification {

    def "should get proper weights percentage" () {
        given:
        Map<String, Double> groups = new HashMap<String, Double> ();

        groups.put("groupA", 2.0d)
        groups.put("groupB", 3.0d)
        groups.put("groupC", 5.0d)

        GroupsConfiguration config = new GroupsConfiguration();
        config.setGroups(groups)

        when:
        def computedPercents = config.getBalance()

        then:
        computedPercents.get("groupA") == 0.2d
        computedPercents.get("groupB") == 0.3d
        computedPercents.get("groupC") == 0.5d
    }
}
