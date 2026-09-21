package com.qe.automation.base;

import com.qe.automation.config.ConfigReader;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.BeforeClass;

public class BaseTest {

    protected RequestSpecification requestSpec;

    private static final Logger logger =
            LoggerFactory.getLogger(BaseTest.class);

    @BeforeClass
    public void setup() {

        String baseUrl =
                ConfigReader.getProperty("baseUrl");

        String authToken =
                ConfigReader.getProperty("authToken");

        logger.info("Starting API test setup");
        logger.info("Base URL: {}", baseUrl);
        logger.info(
                "Authentication configured: {}",
                authToken != null && !authToken.isBlank()
        );

        RequestSpecBuilder builder =
                new RequestSpecBuilder()
                        .setBaseUri(baseUrl)
                        .setContentType(ContentType.JSON);

        if (authToken != null && !authToken.isBlank()) {

            builder.addHeader(
                    "Authorization",
                    "Bearer " + authToken
            );

            logger.info("Authorization header configured");
        }

        requestSpec = builder.build();

        logger.info("Request specification created successfully");
    }
}