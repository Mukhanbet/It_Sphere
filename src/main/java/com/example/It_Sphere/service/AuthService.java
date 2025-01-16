package com.example.It_Sphere.service;

import com.example.It_Sphere.model.dto.auth.AuthResponse;
import com.example.It_Sphere.model.dto.auth.LoginRequest;
import com.example.It_Sphere.model.dto.auth.RegisterRequest;

public interface AuthService {
    AuthResponse register(RegisterRequest request);
    AuthResponse login(LoginRequest request);
}
