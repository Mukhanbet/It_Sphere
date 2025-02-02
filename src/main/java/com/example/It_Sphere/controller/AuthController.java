package com.example.It_Sphere.controller;

import com.example.It_Sphere.model.dto.auth.AuthResponse;
import com.example.It_Sphere.model.dto.auth.LoginRequest;
import com.example.It_Sphere.model.dto.auth.RegisterRequest;
import com.example.It_Sphere.service.AuthService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/auth")
@CrossOrigin(origins = "*", maxAge = 3600)
public class AuthController {
    private final AuthService authService;

    @PostMapping("/register")
    public AuthResponse register(@RequestBody RegisterRequest request) {
         return authService.register(request);
    }

    @PostMapping("/login")
    public AuthResponse login(@RequestBody LoginRequest request) {
        return authService.login(request);
    }
}
