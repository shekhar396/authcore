package com.authcore.service;
import com.authcore.dto.RegisterRequest;
import com.authcore.repository.UserRepository;
import com.authcore.service.impl.AuthServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class AuthServiceTest {

    @Mock
    UserRepository userRepository;

    @InjectMocks
    AuthServiceImpl authService;

    @Test
    void testRegistrationWithInvalidData() {
        RegisterRequest invalidRequest = new RegisterRequest();
        invalidRequest.setUsername(""); // invalid username
        invalidRequest.setPassword("123"); // invalid password (too short)

        RuntimeException exception = assertThrows(RuntimeException.class, () -> {
            authService.registerUser(invalidRequest);
        });

        assertTrue(exception.getMessage().contains("Username is required")
                || exception.getMessage().contains("Password must be at least 6 characters"));
    }

    @Test
    void testRegistrationWithExistingUsername() {
        RegisterRequest request = new RegisterRequest();
        request.setUsername("existingUser");
        request.setPassword("validPassword");

        // Mock userRepository to say username exists
        when(userRepository.existsByUsername("existingUser")).thenReturn(true);

        RuntimeException exception = assertThrows(RuntimeException.class, () -> {
            authService.registerUser(request);
        });

        assertTrue(exception.getMessage().contains("Username already exists"));
    }
}

