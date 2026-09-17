package com.qe.automation.tests;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class FirstApiTest {

    @Test
    public void getUsersTest() {

        given()
            .baseUri("https://reqres.in")

        .when()
            .get("/api/users?page=2")

        .then()
            .statusCode(200)
            .body("page", equalTo(2))
            .body("data.size()", greaterThan(0))
            .body("data[0].id", equalTo(7))
            .body("data[0].first_name", equalTo("Michael"))
            .body("data[0].last_name", equalTo("Lawson"));
    }
}