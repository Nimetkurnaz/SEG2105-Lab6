package com.example.lab6;

import org.junit.Assert;
import org.junit.Test;

public class LoginValidatorTest {

    private final LoginValidator validator = new LoginValidator();

    @Test
    public void testInputsValidation() {
        // validating valid inputs
        Assert.assertTrue(validator.isValidName("John"));
        Assert.assertTrue(validator.isValidLastName("Doe"));
        Assert.assertTrue(validator.isValidPassword("password123"));

        // validating invalid inputs
        Assert.assertFalse(validator.isValidName("123")); // Invalid name
        Assert.assertFalse(validator.isValidLastName(""));  // Invalid last name (empty)
        Assert.assertFalse(validator.isValidPassword("12")); // Invalid password (too short)
    }
}
