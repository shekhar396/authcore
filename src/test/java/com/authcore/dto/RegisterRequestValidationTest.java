package com.authcore.dto;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

public class RegisterRequestValidationTest {

    private static Validator validator;

    @BeforeAll
    public static void setupValidator() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @Test
    public void testValidRegisterRequest() {
        RegisterRequest request = new RegisterRequest();
        request.setUsername("shekhar007");
        request.setEmail("shekhar@example.com");
        request.setPassword("P@ssw0rd123");

        Set<ConstraintViolation<RegisterRequest>> violations = validator.validate(request);
        assertTrue(violations.isEmpty(), "Valid input should have no violations");
    }

    @Test
    public void testBlankFields() {
        RegisterRequest request = new RegisterRequest();
        request.setUsername("");                   // Invalid: blank
        request.setEmail("not-an-email");          // Invalid: not an email
        request.setPassword("123");                // Invalid: too short & doesn't match pattern

        Set<ConstraintViolation<RegisterRequest>> violations = validator.validate(request);

        // Print for debugging
        violations.forEach(v -> System.out.println(v.getPropertyPath() + ": " + v.getMessage()));

        assertFalse(violations.isEmpty(), "Violations should not be empty");

        long usernameErrors = violations.stream()
                .filter(v -> v.getPropertyPath().toString().equals("username"))
                .count();

        long emailErrors = violations.stream()
                .filter(v -> v.getPropertyPath().toString().equals("email"))
                .count();

        long passwordErrors = violations.stream()
                .filter(v -> v.getPropertyPath().toString().equals("password"))
                .count();

        // You can assert at least 1 error per field
        assertTrue(usernameErrors >= 1, "Username should have validation errors");
        assertTrue(emailErrors >= 1, "Email should have validation errors");
        assertTrue(passwordErrors >= 1, "Password should have validation errors");

        // Optional: total count
        assertEquals(4, violations.size(), "Expected 4 constraint violations");
    }

    @Test
    public void testInvalidEmail() {
        RegisterRequest request = new RegisterRequest();
        request.setUsername("shekhar");
        request.setEmail("invalid-email");
        request.setPassword("P@ssw0rd123");

        Set<ConstraintViolation<RegisterRequest>> violations = validator.validate(request);
        assertTrue(violations.stream().anyMatch(v -> v.getPropertyPath().toString().equals("email")));
    }

    @Test
    public void testWeakPassword() {
        RegisterRequest request = new RegisterRequest();
        request.setUsername("shekhar");
        request.setEmail("shekhar@example.com");
        request.setPassword("password"); // weak password

        Set<ConstraintViolation<RegisterRequest>> violations = validator.validate(request);
        assertTrue(violations.stream().anyMatch(v -> v.getPropertyPath().toString().equals("password")));
    }
}
