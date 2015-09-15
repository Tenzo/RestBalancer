package com.balancer.endpoint

import spock.lang.Specification

import javax.ws.rs.client.Client
import javax.ws.rs.client.ClientBuilder
import javax.ws.rs.client.WebTarget
import javax.ws.rs.core.Response

class UserGroupIntegrationTest extends Specification {

    def GROUP_URL = "http://localhost:8080/restBalancer/group"

    def "should response with group assigned to user" () {
        given:
        Client client = ClientBuilder.newClient()
        WebTarget webResource = client.target(GROUP_URL)

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

    def "should response with BAD_REQUEST for invalid user id" () {
        given:
        Client client = ClientBuilder.newClient()
        WebTarget webResource = client.target(GROUP_URL)

        when:
        Response response = webResource.queryParam("userId", userId)
                .request("text/plain")
                .get(String.class)

        then:
        response.status = 422

        where:
        userId    | _
        "abc12#"  | _
        "user23." | _
    }
}
