package com.balancer.utils

import spock.lang.Specification

class IdValidatorTest extends Specification {

    def "should validate user id" () {
        expect:
        IdValidator.validateId(userId)

        where:
        userId     | _
        "test" | _
        "LuBiE345" | _
        "siema435" | _
    }

    def "should not validate user id" () {
        expect:
        !IdValidator.validateId(userId)

        where:
        userId     | _
        "test213%" | _
        "LuBiE34ś" | _
        "siema43." | _

    }
}
