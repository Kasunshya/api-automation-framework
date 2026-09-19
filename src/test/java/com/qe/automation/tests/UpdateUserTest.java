package com.qe.automation.tests;

import com.qe.automation.base.BaseTest;
import com.qe.automation.endpoints.UserEndpoints;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class UpdateUserTest extends BaseTest {

    @Test
    public void updateUserTest() {

        String requestBody = """
                {
                    "name": "Kasunshya Updated",
                    "job": "Senior QA Engineer"
                }
                """;

        given()
            .spec(requestSpec)
            .body(requestBody)
            .pathParam("userId", 2)

        .when()
            .put(UserEndpoints.USER_BY_ID)

        .then()
            .statusCode(200)
            .body("name", equalTo("Kasunshya Updated"))
            .body("job", equalTo("Senior QA Engineer"));
    }
}