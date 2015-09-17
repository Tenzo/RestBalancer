package com.balancer.utils

import com.balancer.configuration.GroupsConfiguration
import spock.lang.Specification

import javax.ws.rs.core.Response

class BalancerTest extends Specification {

    def "should get 201 created for new user" () {
        given:
        Map<String, Double> groups = new HashMap<String, Double>();
        groups.put("groupA", 2.0d)
        groups.put("groupB", 3.0d)
        groups.put("groupC", 5.0d)
        GroupsConfiguration config = new GroupsConfiguration()
        config.setGroups(groups)
        Balancer balancer = new Balancer(config)

        when:
        def response = balancer.getGroupForUser(userId)

        then:
        response.status == Response.Status.CREATED.statusCode

        where:
        userId  | _
        "user1" | _
        "abc23" | _
        "cos45" | _
    }

    def "should get 200 ok for existing user" () {
        given:
        Map<String, Double> groups = new HashMap<String, Double>();
        groups.put("groupA", 2.0d)
        groups.put("groupB", 3.0d)
        groups.put("groupC", 5.0d)
        GroupsConfiguration config = new GroupsConfiguration()
        config.setGroups(groups)
        Balancer balancer = new Balancer(config)

        when:
        balancer.getGroupForUser(userId)
        def response = balancer.getGroupForUser(userId)

        then:
        response.status == Response.Status.OK.statusCode

        where:
        userId  | _
        "user1" | _
        "abc23" | _
        "cos45" | _
    }

    def "should balance users properly" () {
        given:
        Map<String, Double> groups = new HashMap<String, Double>();
        groups.put("groupA", 2.0d)
        groups.put("groupB", 3.0d)
        groups.put("groupC", 5.0d)
        Map<String, Integer> groupsCapacity = new HashMap<String, Double>();
        groupsCapacity.put("groupA", 0)
        groupsCapacity.put("groupB", 0)
        groupsCapacity.put("groupC", 0)
        GroupsConfiguration config = new GroupsConfiguration()
        config.setGroups(groups)
        Balancer balancer = new Balancer(config)

        when:
        (1..(10 * multiplyer)).each {
            def givenGroup = balancer.getGroupForUser("user${it}").getEntity().toString()
            groupsCapacity.put(givenGroup, groupsCapacity.get(givenGroup) + 1)
        }

        then:
        groupsCapacity.get("groupA") == 2 * multiplyer
        groupsCapacity.get("groupB") == 3 * multiplyer
        groupsCapacity.get("groupC") == 5 * multiplyer

        where:
        multiplyer | _
        1          | _
        2          | _
        15         | _
    }

}
