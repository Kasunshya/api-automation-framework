package com.qe.automation.services;

import com.qe.automation.endpoints.UserEndpoints;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

public class UserService {

    private final RequestSpecification requestSpec;

    public UserService(RequestSpecification requestSpec) {
        this.requestSpec = requestSpec;
    }

    public Response getUsers(int page) {

        return given()
                .spec(requestSpec)
                .queryParam("page", page)

                .when()
                .get(UserEndpoints.USERS);
    }

    public Response getUser(int userId) {

        return given()
                .spec(requestSpec)
                .pathParam("userId", userId)

                .when()
                .get(UserEndpoints.USER_BY_ID);
    }

    public Response createUser(String requestBody) {

        return given()
                .spec(requestSpec)
                .body(requestBody)

                .when()
                .post(UserEndpoints.USERS);
    }

    public Response updateUser(int userId, String requestBody) {

        return given()
                .spec(requestSpec)
                .pathParam("userId", userId)
                .body(requestBody)

                .when()
                .put(UserEndpoints.USER_BY_ID);
    }

    public Response deleteUser(int userId) {

        return given()
                .spec(requestSpec)
                .pathParam("userId", userId)

                .when()
                .delete(UserEndpoints.USER_BY_ID);
    }
}