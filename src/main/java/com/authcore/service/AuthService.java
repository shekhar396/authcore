package com.authcore.service;

import com.authcore.dto.AuthResponse;
import com.authcore.dto.RegisterRequest;

public interface AuthService {

    AuthResponse registerUser(RegisterRequest request);
}
