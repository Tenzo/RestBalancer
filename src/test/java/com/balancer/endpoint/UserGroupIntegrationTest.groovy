package com.balancer.endpoint

import spock.lang.Specification
import spock.lang.Unroll

import javax.ws.rs.client.Client
import javax.ws.rs.client.ClientBuilder
import javax.ws.rs.client.WebTarget

class UserGroupIntegrationTest extends Specification {

    def HELLO_URL = "http://localhost:8080/restBalancer/group"

    @Unroll
    def "should response with group assigned to user" () {
        given:
        Client client = ClientBuilder.newClient()
        WebTarget webResource = client.target(HELLO_URL)

        when:
        String response = webResource.queryParam("userId", userId)
                            .request("text/plain")
                            .get(String.class)

        then:
        response in ["groupA", "groupB", "groupC"]

        where:
        userId    | _
        "abc123"  | _
        "user234" | _


    }
}
