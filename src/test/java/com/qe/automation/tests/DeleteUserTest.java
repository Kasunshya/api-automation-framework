package com.qe.automation.tests;

import com.qe.automation.base.BaseTest;
import com.qe.automation.endpoints.UserEndpoints;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class DeleteUserTest extends BaseTest {

    @Test
    public void deleteUserTest() {

        given()
            .spec(requestSpec)
            .pathParam("userId", 2)

        .when()
            .delete(UserEndpoints.USER_BY_ID)

        .then()
            .statusCode(204);
    }
}