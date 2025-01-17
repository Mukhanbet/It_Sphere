package com.example.It_Sphere.mapper;

import com.example.It_Sphere.model.domain.Feedback;
import com.example.It_Sphere.model.domain.User;
import com.example.It_Sphere.model.dto.feedback.FeedbackResponse;

import java.util.List;

public interface FeedbackMapper {
    Feedback toFeedback(String message, User user);
    FeedbackResponse toResponse(Feedback feedback);
    List<FeedbackResponse> toResponseList(List<Feedback> feedbacks);
}
