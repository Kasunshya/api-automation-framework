package com.qe.automation.tests;

import com.qe.automation.base.BaseTest;
import com.qe.automation.services.UserService;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GetInvalidUserTest extends BaseTest {

    @Test
    public void getInvalidUserTest() {

        // Create service object
        UserService userService =
                new UserService(requestSpec);

        // Request a user that does not exist
        Response response =
                userService.getUser(9999);

        // Print response
        response.prettyPrint();

        // Validate status code
        Assert.assertEquals(
                response.statusCode(),
                404
        );
    }
}