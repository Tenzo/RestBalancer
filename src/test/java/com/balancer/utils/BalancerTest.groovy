package com.balancer.utils

import com.balancer.handler.UserIdValidationException
import spock.lang.Specification

class BalancerTest extends Specification {

    def "should get testing group for user" () {

        given:
        Balancer balancer = new Balancer()

        when:
        def group = balancer.getGroup(userId)

        then:
        group in ["groupA", "groupB", "groupC"]

        where:
            userId    | _
            "user123" | _
            "user345" | _
            "asdd234" | _
    }

    def "should throw exception for invalid user id" () {
        given:
        Balancer balancer = new Balancer()

        when:
        balancer.getGroup(userId)

        then:
        thrown(UserIdValidationException.class)

        where:
        userId    | _
        "user12%" | _
        "user34." | _
        "asdd23ś" | _
    }
}
