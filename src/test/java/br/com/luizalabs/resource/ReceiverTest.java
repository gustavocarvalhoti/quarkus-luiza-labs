package br.com.luizalabs.resource;

import io.quarkus.test.junit.QuarkusTest;
import io.restassured.RestAssured;
import org.junit.jupiter.api.Test;

@QuarkusTest
public class ReceiverTest {

    @Test
    public void testStatusCode200() {
        RestAssured.given().get("/receiver").then().statusCode(200);
    }
}