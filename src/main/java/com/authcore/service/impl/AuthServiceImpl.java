package com.authcore.service.impl;

import com.authcore.dto.AuthResponse;
import com.authcore.dto.RegisterRequest;
import com.authcore.entity.User;
import com.authcore.repository.UserRepository;
import com.authcore.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public AuthResponse registerUser(RegisterRequest request) {

        User user = User.builder()
                .username(request.getUsername())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .status("ACTIVE")
                .isVerified(true)
                .build();

        userRepository.save(user);

        return new AuthResponse("dummy-access-token", "dummy-refresh-token");
    }
}
