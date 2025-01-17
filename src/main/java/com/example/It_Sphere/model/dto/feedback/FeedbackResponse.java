package com.example.It_Sphere.model.dto.feedback;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class FeedbackResponse {
    private String userEmail;
    private String message;
    private LocalDateTime createdAt;
}
