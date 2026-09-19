package com.qe.automation.tests;

import com.qe.automation.base.BaseTest;
import com.qe.automation.services.UserService;
import io.restassured.response.Response;
import org.testng.annotations.Test;

public class DeleteUserTest extends BaseTest {

    @Test
    public void deleteUserTest() {

        UserService userService = new UserService(requestSpec);

        Response response = userService.deleteUser(2);

        response.then()
                .statusCode(204);
    }
}