package br.com.luizalabs.resource;

import br.com.luizalabs.model.SchedulingNotification;
import br.com.luizalabs.service.SchedulingNotificationService;
import io.quarkus.test.junit.QuarkusTest;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;

import static io.restassured.RestAssured.given;

@QuarkusTest
public class SchedulingNotificationTest {

    @Inject
    SchedulingNotificationService schedulingNotificationService;

    /* Original JSON
    {
       "status":"pending",
       "sendDate":"2021-04-25 01:00:00",
       "message":"TESTE147852369",
       "type":"whatsapp",
       "receivers":[
          {
             "name":"Marli",
             "phone":"+55 19991676181"
          },
             {
             "name":"Michelle",
             "phone":"+55 19991676181"
          }
       ]
    }
    */

    private static String requestBodyPersist = "{\n" +
            "       \"status\":\"pending\",\n" +
            "       \"sendDate\":\"2021-04-25 01:00:00\",\n" +
            "       \"message\":\"TESTE147852369\",\n" +
            "       \"type\":\"whatsapp\",\n" +
            "       \"receivers\":[\n" +
            "          {\n" +
            "             \"name\":\"Marli\",\n" +
            "             \"phone\":\"+55 19991676181\"\n" +
            "          },\n" +
            "             {\n" +
            "             \"name\":\"Michelle\",\n" +
            "             \"phone\":\"+55 19991676181\"\n" +
            "          }\n" +
            "       ]\n" +
            "    }";

    @Test
    public void testStatusCode200ListAll() {
        given().get("/scheduling-notification").then().statusCode(200);
    }

    @Test
    public void testPersist() {
        Response response = given()
                .header("Content-type", "application/json")
                .and()
                .body(requestBodyPersist)
                .when()
                .post("/scheduling-notification")
                .then()
                .extract()
                .response();

        Assertions.assertEquals(204, response.statusCode());
    }

    @Test
    public void testCancelSchedulingNotification() {
        SchedulingNotification notification = schedulingNotificationService.findByMessage("TESTE147852369");

        Response response = given()
                .patch("/scheduling-notification/cancel/" + notification.getId())
                .then()
                .extract()
                .response();

        Assertions.assertEquals(204, response.statusCode());

        schedulingNotificationService.deleteByMessage("TESTE147852369");
    }
}