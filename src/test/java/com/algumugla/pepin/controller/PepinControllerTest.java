package com.algumugla.pepin.controller;

import org.json.JSONObject;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PepinControllerTest {

    private static final String EXPECTED_RESPONSE_VALUE = "Hello Pepin!";
    private static final String INPUT_NAME = "Pepin";

    private final PepinController controller = new PepinController();

    @BeforeAll
    static void setup() {
        // Use as needed. 
    }

    @AfterAll
    static void tearDown() {
        // Use as needed.
    }

    @Test
    void testGetRequestWithDefinedValue() {
        ResponseEntity responseEntity = controller.helloPepinGet(INPUT_NAME);

        JSONObject jsonObjectFromResponse = new JSONObject(responseEntity.getBody().toString());

        assertEquals(EXPECTED_RESPONSE_VALUE, jsonObjectFromResponse.get("Output"));
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
    }

    @Test
    void testPostRequestWithDefinedValue() {
        ResponseEntity responseEntity = controller.helloPepinPost(INPUT_NAME);

        JSONObject jsonObjectFromResponse = new JSONObject(responseEntity.getBody().toString());

        assertEquals(EXPECTED_RESPONSE_VALUE, jsonObjectFromResponse.get("Output"));
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
    }

}