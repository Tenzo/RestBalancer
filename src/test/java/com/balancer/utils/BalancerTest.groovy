package com.balancer.utils

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
}
