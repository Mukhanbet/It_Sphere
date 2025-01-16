package com.example.It_Sphere.model.dto.auth;

import lombok.Builder;
import lombok.Data;

@Data
public class AuthResponse {
    private Long id;
    private String token;
}
