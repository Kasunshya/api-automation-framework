package com.qe.automation.config;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.InputStream;

public class TestDataReader {

    private static final ObjectMapper objectMapper =
            new ObjectMapper();

    public static JsonNode getTestData() {

        try (InputStream input =
                     TestDataReader.class
                             .getClassLoader()
                             .getResourceAsStream(
                                     "testdata/user-data.json"
                             )) {

            if (input == null) {
                throw new RuntimeException(
                        "user-data.json file not found"
                );
            }

            return objectMapper.readTree(input);

        } catch (Exception e) {
            throw new RuntimeException(
                    "Failed to read test data",
                    e
            );
        }
    }
}