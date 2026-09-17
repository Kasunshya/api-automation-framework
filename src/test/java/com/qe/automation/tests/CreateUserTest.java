package com.qe.automation.tests;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class CreateUserTest {

    @Test
    public void createUserTest() {

        String requestBody = """
                {
                    "name": "Kasunshya",
                    "job": "QA Engineer"
                }
                """;

        given()
            .baseUri("https://reqres.in")
            .contentType("application/json")
            .body(requestBody)

        .when()
            .post("/api/users")

        .then()
            .statusCode(201)
            .body("name", equalTo("Kasunshya"))
            .body("job", equalTo("QA Engineer"));
    }
}