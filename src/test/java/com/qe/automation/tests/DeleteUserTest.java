package com.qe.automation.tests;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class DeleteUserTest {

    @Test
    public void deleteUserTest() {

        given()
            .baseUri("https://reqres.in")
            .pathParam("userId", 2)

        .when()
            .delete("/api/users/{userId}")

        .then()
            .statusCode(204);
    }
}