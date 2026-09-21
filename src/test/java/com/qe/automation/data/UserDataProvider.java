package com.qe.automation.data;

import org.testng.annotations.DataProvider;

public class UserDataProvider {

    @DataProvider(name = "userData")
    public Object[][] userData() {

        return new Object[][] {
                {"Kasunshya", "QA Engineer"},
                {"Test User", "Software Engineer"},
                {"API User", "Automation Engineer"}
        };
    }
}