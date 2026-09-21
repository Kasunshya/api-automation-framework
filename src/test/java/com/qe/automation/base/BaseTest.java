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

        requestSpec = new RequestSpecBuilder()
                .setBaseUri(baseUrl)
                .setContentType(ContentType.JSON)
                .build();
    }
}