package com.qe.automation.tests;

import com.qe.automation.base.BaseTest;
import com.qe.automation.services.UserService;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static org.hamcrest.Matchers.*;

public class GetUserTest extends BaseTest {

    @Test
    public void getSingleUserTest() {

        UserService userService = new UserService(requestSpec);

        Response response = userService.getUser(2);

        response.then()
                .statusCode(200)
                .body("data.id", equalTo(2))
                .body("data.first_name", equalTo("Janet"))
                .body("data.last_name", equalTo("Weaver"));
    }
}