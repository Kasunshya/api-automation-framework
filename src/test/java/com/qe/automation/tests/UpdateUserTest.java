package com.qe.automation.tests;

import com.qe.automation.base.BaseTest;
import com.qe.automation.services.UserService;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static org.hamcrest.Matchers.*;

public class UpdateUserTest extends BaseTest {

    @Test
    public void updateUserTest() {

        String requestBody = """
                {
                    "name": "Kasunshya Updated",
                    "job": "Senior QA Engineer"
                }
                """;

        UserService userService = new UserService(requestSpec);

        Response response = userService.updateUser(2, requestBody);

        response.then()
                .statusCode(200)
                .body("name", equalTo("Kasunshya Updated"))
                .body("job", equalTo("Senior QA Engineer"));
    }
}