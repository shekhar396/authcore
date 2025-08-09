package com.authcore.controller;

import com.authcore.api.AuthApi;
import com.authcore.dto.AuthResponse;
import com.authcore.dto.RegisterRequest;
import com.authcore.service.AuthService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController implements AuthApi {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @Override
    public ResponseEntity<AuthResponse> register(RegisterRequest request) {
        return ResponseEntity.ok(authService.registerUser(request));
    }
}
