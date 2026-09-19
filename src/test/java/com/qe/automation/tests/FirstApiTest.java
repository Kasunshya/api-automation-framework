package com.qe.automation.tests;

import com.qe.automation.base.BaseTest;
import com.qe.automation.services.UserService;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static org.hamcrest.Matchers.*;

public class FirstApiTest extends BaseTest {

    @Test
    public void getUsersTest() {

        UserService userService = new UserService(requestSpec);

        Response response = userService.getUsers(2);

        response.then()
                .statusCode(200)
                .body("page", equalTo(2))
                .body("data.size()", greaterThan(0))
                .body("data[0].id", equalTo(7))
                .body("data[0].first_name", equalTo("Michael"))
                .body("data[0].last_name", equalTo("Lawson"));
    }
}