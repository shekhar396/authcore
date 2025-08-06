package com.authcore.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
@Schema(description = "Authentication response with access and refresh tokens")
public class AuthResponse {

    @Schema(description = "JWT access token", example = "eyJhbGciOiJIUzI1NiIsInR5cCI6...")
    private final String accessToken;

    @Schema(description = "JWT refresh token", example = "dGhpcyBpcyBhIHJlZnJlc2ggdG9rZW4=")
    private final String refreshToken;
}

