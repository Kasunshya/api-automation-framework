package com.qe.automation.tests;

import com.qe.automation.base.BaseTest;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class GetUserTest extends BaseTest {

    @Test
    public void getSingleUserTest() {

        given()
            .spec(requestSpec)
            .pathParam("userId", 2)

        .when()
            .get("/api/users/{userId}")

        .then()
            .statusCode(200)
            .body("data.id", equalTo(2))
            .body("data.first_name", equalTo("Janet"))
            .body("data.last_name", equalTo("Weaver"));
    }
}