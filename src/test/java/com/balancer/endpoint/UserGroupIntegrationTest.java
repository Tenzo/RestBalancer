package com.balancer.endpoint;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class UserGroupIntegrationTest {
    private static String HELLO_URL = "http://localhost:8080/restBalancer/group";

    @Test
    public void testSayhello() throws Exception {
        Client client = ClientBuilder.newClient();
        WebTarget webResource = client.target(HELLO_URL);
        String response = webResource.request("text/plain").get(String.class);

        assertEquals(response, "hello");

    }
}