package com.example.findmyclassmate;

import org.junit.Test;
import static org.junit.Assert.*;

public class CreateProfileTest {

    @Test
    public void testInputValidation() {
        // Test with valid name and type
        assertTrue("Input should be valid", isValidInput("John", "Student"));

        // Test with empty name
        assertFalse("Input should be invalid with empty name", isValidInput("", "Student"));

        // Test with empty type
        assertFalse("Input should be invalid with empty type", isValidInput("John", ""));
    }

    // Simple validation method to check if inputs are not empty
    private boolean isValidInput(String name, String type) {
        return name != null && !name.isEmpty() && type != null && !type.isEmpty();
    }
}