package com.qe.automation.tests;

import com.qe.automation.base.BaseTest;
import com.qe.automation.models.SingleUserResponse;
import com.qe.automation.services.UserService;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GetUserTest extends BaseTest {

    @Test
    public void getSingleUserTest() {

        // Create service object
        UserService userService =
                new UserService(requestSpec);

        // Send GET request
        Response response =
                userService.getUser(2);

        // Print response
        response.prettyPrint();

        // Validate status code
        Assert.assertEquals(response.statusCode(), 200);

        // Convert JSON response to Java object
        SingleUserResponse userResponse =
                response.as(SingleUserResponse.class);

        // Print user details
        System.out.println("User ID: " + userResponse.getData().getId());
        System.out.println("First Name: " + userResponse.getData().getFirst_name());
        System.out.println("Last Name: " + userResponse.getData().getLast_name());
        System.out.println("Email: " + userResponse.getData().getEmail());

        // Validate user details
        Assert.assertEquals(
                userResponse.getData().getId(),
                Integer.valueOf(2)
        );

        Assert.assertEquals(
                userResponse.getData().getFirst_name(),
                "Janet"
        );

        Assert.assertEquals(
                userResponse.getData().getLast_name(),
                "Weaver"
        );
    }
}