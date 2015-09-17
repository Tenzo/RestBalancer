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

}
