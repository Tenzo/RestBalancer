package com.balancer.model

import spock.lang.Specification

class UsersRepositoryTest extends Specification {

    def "should get empty optional for non existing user" () {
        given:
        Map<String, Double> groups = new HashMap<String, Double>();
        groups.put("groupA", 2.0d)
        groups.put("groupB", 3.0d)
        groups.put("groupC", 5.0d)

        UsersRepository repository = new UsersRepository(groups)

        when:
        def userExists = repository.getUserGroup("userId")

        then:
        !userExists.isPresent()
    }

    def "should get the same group after addding user" () {
        given:
        Map<String, Double> groups = new HashMap<String, Double>();
        groups.put("groupA", 2.0d)
        groups.put("groupB", 3.0d)
        groups.put("groupC", 5.0d)

        UsersRepository repository = new UsersRepository(groups)

        when:
        repository.addUserToGroup(group, userId)
        def givenGroup = repository.getUserGroup(userId)

        then:
        givenGroup.isPresent()
        group == givenGroup.get()

        where:
        userId  | group
        "user1" | "groupA"
        "abc23" | "groupB"
        "cos45" | "groupC"
    }

}
