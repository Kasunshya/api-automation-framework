package com.qe.automation.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class TestDataReader {

    private static final Properties properties = new Properties();

    static {
        try (InputStream input =
                     TestDataReader.class
                             .getClassLoader()
                             .getResourceAsStream(
                                     "testdata/users.properties"
                             )) {

            if (input == null) {
                throw new RuntimeException(
                        "users.properties file not found"
                );
            }

            properties.load(input);

        } catch (IOException e) {
            throw new RuntimeException(
                    "Failed to load users.properties",
                    e
            );
        }
    }

    public static String getProperty(String key) {
        return properties.getProperty(key);
    }
}