package com.qe.automation.tests;

import com.qe.automation.base.BaseTest;
import com.qe.automation.models.UserListResponse;
import com.qe.automation.services.UserService;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

public class FirstApiTest extends BaseTest {

    @Test
    public void getUsersTest() {

        // Create service object
        UserService userService =
                new UserService(requestSpec);

        // Send GET request
        Response response =
                userService.getUsers(2);

        // Print response
        response.prettyPrint();

        // Validate status code
        Assert.assertEquals(
                response.statusCode(),
                200
        );

        // Validate response header
        Assert.assertTrue(
                response.getHeader("Content-Type")
                        .contains("application/json")
        );

        // Validate JSON schema
        response.then()
                .assertThat()
                .body(
                        matchesJsonSchemaInClasspath(
                                "schemas/users-list-schema.json"
                        )
                );

        // Convert JSON response to Java object
        UserListResponse userResponse =
                response.as(UserListResponse.class);

        // Print response details
        System.out.println(
                "Page: " + userResponse.getPage()
        );

        System.out.println(
                "Total Users: " + userResponse.getTotal()
        );

        System.out.println(
                "Total Pages: " + userResponse.getTotal_pages()
        );

        System.out.println(
                "Users on Page: " +
                userResponse.getData().size()
        );

        // Validate page information
        Assert.assertEquals(
                userResponse.getPage(),
                Integer.valueOf(2)
        );

        // Validate that users exist
        Assert.assertTrue(
                userResponse.getData().size() > 0
        );

        // Validate first user
        Assert.assertEquals(
                userResponse.getData().get(0).getId(),
                Integer.valueOf(7)
        );

        Assert.assertEquals(
                userResponse.getData().get(0).getFirst_name(),
                "Michael"
        );

        Assert.assertEquals(
                userResponse.getData().get(0).getLast_name(),
                "Lawson"
        );
    }
}