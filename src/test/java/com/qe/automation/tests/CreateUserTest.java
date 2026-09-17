package com.qe.automation.tests;

import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class CreateUserTest {

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
                    .baseUri("https://reqres.in")
                    .contentType("application/json")
                    .body(requestBody)

                .when()
                    .post("/api/users");

        // Print complete response
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

        // Validate extracted values
        Assert.assertEquals(userName, "Kasunshya");
        Assert.assertEquals(job, "QA Engineer");
    }
}