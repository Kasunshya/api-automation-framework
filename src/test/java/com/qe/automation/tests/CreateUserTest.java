package com.qe.automation.tests;

import com.qe.automation.base.BaseTest;
import com.qe.automation.models.UserRequest;
import com.qe.automation.models.UserResponse;
import com.qe.automation.services.UserService;
import com.qe.automation.utils.LoggerUtil;
import com.qe.automation.utils.TestDataProvider;
import io.restassured.response.Response;
import org.slf4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CreateUserTest extends BaseTest {

    private static final Logger logger =
            LoggerUtil.getLogger(CreateUserTest.class);

    @Test(
            dataProvider = "userData",
            dataProviderClass = TestDataProvider.class
    )
    public void createUserTest(String name, String job) {

        logger.info(
                "Starting create user test for: {} - {}",
                name,
                job
        );

        UserRequest userRequest =
                new UserRequest(name, job);

        UserService userService =
                new UserService(requestSpec);

        logger.info("Sending create user request");

        Response response =
                userService.createUser(userRequest);

        response.prettyPrint();

        logger.info(
                "Create user response status: {}",
                response.statusCode()
        );

        Assert.assertEquals(
                response.statusCode(),
                201
        );

        UserResponse userResponse =
                response.as(UserResponse.class);

        logger.info(
                "Created user ID: {}",
                userResponse.getId()
        );

        logger.info(
                "Created user name: {}",
                userResponse.getName()
        );

        logger.info(
                "Created user job: {}",
                userResponse.getJob()
        );

        Assert.assertEquals(
                userResponse.getName(),
                name
        );

        Assert.assertEquals(
                userResponse.getJob(),
                job
        );

        logger.info("Create user test completed successfully");
    }
}