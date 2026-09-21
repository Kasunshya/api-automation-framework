package com.qe.automation.services;

import com.qe.automation.endpoints.UserEndpoints;
import com.qe.automation.models.UserRequest;
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

    public Response createUser(UserRequest userRequest) {

        return given()
                .spec(requestSpec)
                .body(userRequest)

                .when()
                .post(UserEndpoints.USERS);
    }

    public Response updateUser(int userId, UserRequest userRequest) {

        return given()
                .spec(requestSpec)
                .pathParam("userId", userId)
                .body(userRequest)

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