package com.qe.automation.tests;

import com.qe.automation.base.BaseTest;
import com.qe.automation.models.UserRequest;
import com.qe.automation.models.UserResponse;
import com.qe.automation.services.UserService;
import com.qe.automation.utils.TestDataReader;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class UserApiChainingTest extends BaseTest {

    @Test
    public void createAndUpdateUserTest() {

        UserService userService =
                new UserService(requestSpec);

        String createName =
                TestDataReader.getProperty("createUser.name");

        String createJob =
                TestDataReader.getProperty("createUser.job");

        UserRequest createRequest =
                new UserRequest(
                        createName,
                        createJob
                );

        Response createResponse =
                userService.createUser(createRequest);

        createResponse.prettyPrint();

        Assert.assertEquals(
                createResponse.statusCode(),
                201
        );

        UserResponse createdUser =
                createResponse.as(UserResponse.class);

        String userId =
                createdUser.getId();

        System.out.println(
                "Created User ID: " + userId
        );

        String updateName =
                TestDataReader.getProperty("updateUser.name");

        String updateJob =
                TestDataReader.getProperty("updateUser.job");

        UserRequest updateRequest =
                new UserRequest(
                        updateName,
                        updateJob
                );

        Response updateResponse =
                userService.updateUser(
                        userId,
                        updateRequest
                );

        updateResponse.prettyPrint();

        Assert.assertEquals(
                updateResponse.statusCode(),
                200
        );

        UserResponse updatedUser =
                updateResponse.as(UserResponse.class);

        Assert.assertEquals(
                updatedUser.getName(),
                updateName
        );

        Assert.assertEquals(
                updatedUser.getJob(),
                updateJob
        );

        System.out.println(
                "Updated User ID: " +
                updatedUser.getId()
        );
    }
}