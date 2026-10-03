package com.qe.automation.services;

import com.qe.automation.endpoints.UserEndpoints;
import com.qe.automation.models.UserRequest;
import com.qe.automation.utils.LoggerUtil;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.slf4j.Logger;

import static io.restassured.RestAssured.given;

public class UserService {

    private static final Logger logger =
            LoggerUtil.getLogger(UserService.class);

    private final RequestSpecification requestSpec;

    public UserService(RequestSpecification requestSpec) {
        this.requestSpec = requestSpec;
    }

    public Response getUsers(int page) {

        logger.info(
                "GET users request - page: {}",
                page
        );

        Response response =
                given()
                        .spec(requestSpec)
                        .queryParam("page", page)
                        .when()
                        .get(UserEndpoints.USERS);

        logger.info(
                "GET users response status: {}",
                response.statusCode()
        );

        return response;
    }

    public Response getUser(int userId) {

        logger.info(
                "GET user request - user ID: {}",
                userId
        );

        Response response =
                given()
                        .spec(requestSpec)
                        .pathParam("userId", userId)
                        .when()
                        .get(UserEndpoints.USER_BY_ID);

        logger.info(
                "GET user response status: {}",
                response.statusCode()
        );

        return response;
    }

    public Response createUser(UserRequest userRequest) {

        logger.info(
                "POST create user request - name: {}, job: {}",
                userRequest.getName(),
                userRequest.getJob()
        );

        Response response =
                given()
                        .spec(requestSpec)
                        .body(userRequest)
                        .when()
                        .post(UserEndpoints.USERS);

        logger.info(
                "POST create user response status: {}",
                response.statusCode()
        );

        return response;
    }

    public Response updateUser(
            String userId,
            UserRequest userRequest) {

        logger.info(
                "PUT update user request - ID: {}, name: {}, job: {}",
                userId,
                userRequest.getName(),
                userRequest.getJob()
        );

        Response response =
                given()
                        .spec(requestSpec)
                        .pathParam("userId", userId)
                        .body(userRequest)
                        .when()
                        .put(UserEndpoints.USER_BY_ID);

        logger.info(
                "PUT update user response status: {}",
                response.statusCode()
        );

        return response;
    }

    public Response deleteUser(int userId) {

        logger.info(
                "DELETE user request - user ID: {}",
                userId
        );

        Response response =
                given()
                        .spec(requestSpec)
                        .pathParam("userId", userId)
                        .when()
                        .delete(UserEndpoints.USER_BY_ID);

        logger.info(
                "DELETE user response status: {}",
                response.statusCode()
        );

        return response;
    }
}