package com.qe.automation.utils;

import org.testng.annotations.DataProvider;

public class TestDataProvider {

    @DataProvider(name = "userData")
    public Object[][] userData() {

        return new Object[][]{
                {"Kasunshya", "QA Engineer"},
                {"Kasunshya Test", "Automation Engineer"},
                {"Test User", "Software Engineer"}
        };
    }
}