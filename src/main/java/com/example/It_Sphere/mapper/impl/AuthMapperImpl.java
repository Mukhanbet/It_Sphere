package com.example.It_Sphere.mapper.impl;

import com.example.It_Sphere.mapper.AuthMapper;
import com.example.It_Sphere.model.domain.User;
import com.example.It_Sphere.model.dto.auth.AuthResponse;
import com.example.It_Sphere.model.dto.auth.RegisterRequest;
import com.example.It_Sphere.model.enums.Role;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class AuthMapperImpl implements AuthMapper {
    @Override
    public User toUser(RegisterRequest request) {
        User user = new User();
        user.setName(request.getName());
        user.setEmail(request.getEmail());
        user.setPassword(request.getPassword());
        user.setCreatedAt(LocalDateTime.now());
        user.setRole(Role.MEMBER);
        return user;
    }

    @Override
    public AuthResponse toResponse(Long id, String token) {
        AuthResponse response = new AuthResponse();
        response.setId(id);
        response.setToken(token);
        return response;
    }
}
