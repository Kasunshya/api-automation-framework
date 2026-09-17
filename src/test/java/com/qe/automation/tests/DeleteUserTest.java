package com.qe.automation.tests;

import com.qe.automation.base.BaseTest;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class DeleteUserTest extends BaseTest {

    @Test
    public void deleteUserTest() {

        given()
            .spec(requestSpec)
            .pathParam("userId", 2)

        .when()
            .delete("/api/users/{userId}")

        .then()
            .statusCode(204);
    }
}