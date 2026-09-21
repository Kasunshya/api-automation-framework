package com.qe.automation.tests;

import com.qe.automation.base.BaseTest;
import com.qe.automation.models.UserRequest;
import com.qe.automation.models.UserResponse;
import com.qe.automation.services.UserService;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CreateUserTest extends BaseTest {

    @Test
    public void createUserTest() {

        // Create request object
        UserRequest userRequest =
                new UserRequest("Kasunshya", "QA Engineer");

        // Create service object
        UserService userService =
                new UserService(requestSpec);

        // Send POST request
        Response response =
                userService.createUser(userRequest);

        // Print response
        response.prettyPrint();

        // Validate status code
        Assert.assertEquals(response.statusCode(), 201);

        // Convert JSON response to UserResponse object
        UserResponse userResponse =
                response.as(UserResponse.class);

        // Print extracted values
        System.out.println("User ID: " + userResponse.getId());
        System.out.println("User Name: " + userResponse.getName());
        System.out.println("Job: " + userResponse.getJob());

        // Validate response values
        Assert.assertEquals(userResponse.getName(), "Kasunshya");
        Assert.assertEquals(userResponse.getJob(), "QA Engineer");
    }
}