package com.example.It_Sphere.model.dto.auth;

import lombok.Builder;
import lombok.Data;

@Data
public class RegisterRequest {
    private String name;
    private String email;
    private String password;
}
