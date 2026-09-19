package com.qe.automation.tests;

import com.qe.automation.base.BaseTest;
import com.qe.automation.endpoints.UserEndpoints;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class FirstApiTest extends BaseTest {

    @Test
    public void getUsersTest() {

        given()
            .spec(requestSpec)
            .queryParam("page", 2)

        .when()
            .get(UserEndpoints.USERS)

        .then()
            .statusCode(200)
            .body("page", equalTo(2))
            .body("data.size()", greaterThan(0))
            .body("data[0].id", equalTo(7))
            .body("data[0].first_name", equalTo("Michael"))
            .body("data[0].last_name", equalTo("Lawson"));
    }
}