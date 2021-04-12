package br.com.luizalabs.resource;

import br.com.luizalabs.service.ReceiverService;
import io.quarkus.test.junit.QuarkusTest;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;

import static io.restassured.RestAssured.given;

@QuarkusTest
public class ReceiverTest {

    @Test
    public void testStatusCode200ListAll() {
        given().get("/receiver").then().statusCode(200);
    }

    private static String requestBody = "{\t\"name\": \"TESTE147852369\",\t\"phone\": \"+55 35355638\"}";

    @Inject
    ReceiverService receiverService;

    @Test
    public void testPersist() {
        Response response = given()
                .header("Content-type", "application/json")
                .and()
                .body(requestBody)
                .when()
                .post("/receiver")
                .then()
                .extract()
                .response();

        Assertions.assertEquals(204, response.statusCode());

        receiverService.delete("TESTE147852369");
    }
}