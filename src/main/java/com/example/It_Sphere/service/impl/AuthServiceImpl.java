package com.example.It_Sphere.service.impl;

import com.example.It_Sphere.config.JwtService;
import com.example.It_Sphere.exception.CustomException;
import com.example.It_Sphere.mapper.AuthMapper;
import com.example.It_Sphere.model.domain.User;
import com.example.It_Sphere.model.dto.auth.AuthResponse;
import com.example.It_Sphere.model.dto.auth.LoginRequest;
import com.example.It_Sphere.model.dto.auth.RegisterRequest;
import com.example.It_Sphere.repository.UserRepository;
import com.example.It_Sphere.service.AuthService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AuthServiceImpl implements AuthService {
    private final UserRepository userRepository;
    private final AuthMapper authMapper;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;

    @Override
    public AuthResponse register(RegisterRequest request) {
        if (!request.getPassword().equals(request.getConfirmPassword())) {
            throw new CustomException("Password is not match", HttpStatus.BAD_REQUEST);
        }
        if(userRepository.findByEmail(request.getEmail()).isPresent()){
            throw new CustomException("User not found", HttpStatus.NOT_FOUND);
        }

        request.setPassword(passwordEncoder.encode(request.getPassword()));
        User user = userRepository.save(authMapper.toUser(request));
        return authMapper.toResponse(user.getId(), jwtService.generateToken(user));
    }

    @Override
    public AuthResponse login(LoginRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()
                )
        );

        User user = userRepository.findByEmail(request.getEmail()).orElseThrow(() -> new CustomException("User not found", HttpStatus.NOT_FOUND));
        return authMapper.toResponse(user.getId(), jwtService.generateToken(user));
    }
}
