package com.qe.automation.tests;

import com.qe.automation.base.BaseTest;
import com.qe.automation.models.UserRequest;
import com.qe.automation.models.UserResponse;
import com.qe.automation.services.UserService;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class UpdateUserTest extends BaseTest {

    @Test
    public void updateUserTest() {

        // Create request object
        UserRequest userRequest =
                new UserRequest(
                        "Kasunshya Updated",
                        "Senior QA Engineer"
                );

        // Create service object
        UserService userService =
                new UserService(requestSpec);

        // Send PUT request
        Response response =
                userService.updateUser(2, userRequest);

        // Print response
        response.prettyPrint();

        // Validate status code
        Assert.assertEquals(response.statusCode(), 200);

        // Convert JSON response to UserResponse object
        UserResponse userResponse =
                response.as(UserResponse.class);

        // Print response values
        System.out.println("User Name: " + userResponse.getName());
        System.out.println("Job: " + userResponse.getJob());
        System.out.println("Updated At: " + userResponse.getUpdatedAt());

        // Validate response values
        Assert.assertEquals(
                userResponse.getName(),
                "Kasunshya Updated"
        );

        Assert.assertEquals(
                userResponse.getJob(),
                "Senior QA Engineer"
        );
    }
}