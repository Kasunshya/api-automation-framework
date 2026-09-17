package com.qe.automation.tests;

import com.qe.automation.base.BaseTest;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class CreateUserTest extends BaseTest {

    @Test
    public void createUserTest() {

        String requestBody = """
                {
                    "name": "Kasunshya",
                    "job": "QA Engineer"
                }
                """;

        Response response =
                given()
                    .spec(requestSpec)
                    .body(requestBody)

                .when()
                    .post("/api/users");

        response.prettyPrint();

        // Validate status code
        Assert.assertEquals(response.statusCode(), 201);

        // Extract response values
        String userName = response.jsonPath().getString("name");
        String job = response.jsonPath().getString("job");
        String userId = response.jsonPath().getString("id");

        System.out.println("User ID: " + userId);
        System.out.println("User Name: " + userName);
        System.out.println("Job: " + job);

        // Validate response values
        Assert.assertEquals(userName, "Kasunshya");
        Assert.assertEquals(job, "QA Engineer");
    }
}