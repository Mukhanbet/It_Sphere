package com.example.It_Sphere.mapper;

import com.example.It_Sphere.model.domain.User;
import com.example.It_Sphere.model.dto.auth.AuthResponse;
import com.example.It_Sphere.model.dto.auth.RegisterRequest;

public interface AuthMapper {
    User toUser(RegisterRequest request);
    AuthResponse toResponse(Long id, String token);
}
