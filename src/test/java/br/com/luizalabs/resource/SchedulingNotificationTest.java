package br.com.luizalabs.resource;

import io.quarkus.test.junit.QuarkusTest;
import io.restassured.RestAssured;
import org.junit.jupiter.api.Test;

@QuarkusTest
public class SchedulingNotificationTest {

    @Test
    public void testStatusCode200() {
        RestAssured.given().get("/scheduling-notification").then().statusCode(200);
    }
}
