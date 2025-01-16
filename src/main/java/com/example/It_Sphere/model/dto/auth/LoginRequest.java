package com.example.It_Sphere.model.dto.auth;

import lombok.Builder;
import lombok.Data;

@Data
public class LoginRequest {
    private String email;
    private String password;
}
