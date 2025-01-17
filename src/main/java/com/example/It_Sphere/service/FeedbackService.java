package com.example.It_Sphere.service;

import com.example.It_Sphere.model.domain.Feedback;
import com.example.It_Sphere.model.dto.feedback.FeedbackResponse;

import java.util.List;

public interface FeedbackService {
    FeedbackResponse leaveFeedback(String message, String token);
    List<FeedbackResponse> all(int page, int size);
}
