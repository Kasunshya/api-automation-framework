package com.qe.automation.base;

import com.qe.automation.config.ConfigReader;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeClass;

public class BaseTest {

    protected RequestSpecification requestSpec;

    @BeforeClass
    public void setup() {

        String baseUrl =
                ConfigReader.getProperty("baseUrl");

        String authToken =
                ConfigReader.getProperty("authToken");

        RequestSpecBuilder builder =
                new RequestSpecBuilder()
                        .setBaseUri(baseUrl)
                        .setContentType(ContentType.JSON);

        if (authToken != null && !authToken.isBlank()) {
            builder.addHeader(
                    "Authorization",
                    "Bearer " + authToken
            );
        }

        requestSpec = builder.build();
    }
}