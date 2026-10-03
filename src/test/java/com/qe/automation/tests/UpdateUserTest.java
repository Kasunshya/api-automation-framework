package com.qe.automation.tests;

import com.qe.automation.base.BaseTest;
import com.qe.automation.models.UserRequest;
import com.qe.automation.models.UserResponse;
import com.qe.automation.services.UserService;
import com.qe.automation.utils.LoggerUtil;
import com.qe.automation.utils.TestDataReader;
import io.restassured.response.Response;
import org.slf4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

public class UpdateUserTest extends BaseTest {

    private static final Logger logger =
            LoggerUtil.getLogger(UpdateUserTest.class);

    @Test
    public void updateUserTest() {

        String name =
                TestDataReader.getProperty("updateUser.name");

        String job =
                TestDataReader.getProperty("updateUser.job");

        logger.info(
                "Starting update user test: {} - {}",
                name,
                job
        );

        UserRequest userRequest =
                new UserRequest(name, job);

        UserService userService =
                new UserService(requestSpec);

        logger.info("Sending update user request for user ID: 2");

        Response response =
                userService.updateUser("2", userRequest);

        response.prettyPrint();

        logger.info(
                "Update user response status: {}",
                response.statusCode()
        );

        Assert.assertEquals(
                response.statusCode(),
                200
        );

        UserResponse userResponse =
                response.as(UserResponse.class);

        logger.info(
                "Updated user name: {}",
                userResponse.getName()
        );

        logger.info(
                "Updated user job: {}",
                userResponse.getJob()
        );

        logger.info(
                "Updated at: {}",
                userResponse.getUpdatedAt()
        );

        Assert.assertEquals(
                userResponse.getName(),
                name
        );

        Assert.assertEquals(
                userResponse.getJob(),
                job
        );

        logger.info("Update user test completed successfully");
    }
}