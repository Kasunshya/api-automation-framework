package com.qe.automation.tests;

import com.qe.automation.base.BaseTest;
import com.qe.automation.models.UserRequest;
import com.qe.automation.models.UserResponse;
import com.qe.automation.services.UserService;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class UserApiChainingTest extends BaseTest {

    @Test
    public void createAndUpdateUserTest() {

        UserService userService =
                new UserService(requestSpec);

        // =========================
        // STEP 1: CREATE USER
        // =========================

        UserRequest createRequest =
                new UserRequest(
                        "Kasunshya",
                        "QA Engineer"
                );

        Response createResponse =
                userService.createUser(createRequest);

        createResponse.prettyPrint();

        // Validate create response
        Assert.assertEquals(
                createResponse.statusCode(),
                201
        );

        // Convert response to UserResponse
        UserResponse createdUser =
                createResponse.as(UserResponse.class);

        // Extract generated user ID
        String userId =
                createdUser.getId();

        System.out.println(
                "Created User ID: " + userId
        );

        // =========================
        // STEP 2: UPDATE USER
        // =========================

        UserRequest updateRequest =
                new UserRequest(
                        "Kasunshya Updated",
                        "Senior QA Engineer"
                );

        Response updateResponse =
                userService.updateUser(
                        userId,
                        updateRequest
                );

        updateResponse.prettyPrint();

        // Validate update response
        Assert.assertEquals(
                updateResponse.statusCode(),
                200
        );

        // Convert update response
        UserResponse updatedUser =
                updateResponse.as(UserResponse.class);

        // Validate updated values
        Assert.assertEquals(
                updatedUser.getName(),
                "Kasunshya Updated"
        );

        Assert.assertEquals(
                updatedUser.getJob(),
                "Senior QA Engineer"
        );

        System.out.println(
                "Updated User ID: " +
                updatedUser.getId()
        );
    }
}