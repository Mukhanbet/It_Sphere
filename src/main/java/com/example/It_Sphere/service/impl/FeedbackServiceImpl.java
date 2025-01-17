package com.example.It_Sphere.service.impl;

import com.example.It_Sphere.config.JwtService;
import com.example.It_Sphere.mapper.FeedbackMapper;
import com.example.It_Sphere.model.domain.Feedback;
import com.example.It_Sphere.model.domain.User;
import com.example.It_Sphere.model.dto.feedback.FeedbackResponse;
import com.example.It_Sphere.repository.FeedbackRepository;
import com.example.It_Sphere.service.FeedbackService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@AllArgsConstructor
public class FeedbackServiceImpl implements FeedbackService {
    private final FeedbackRepository feedbackRepository;
    private final FeedbackMapper feedbackMapper;
    private final JwtService jwtService;
    @Override
    public FeedbackResponse leaveFeedback(String message, String token) {
        User user = jwtService.getUserFromToken(token);
        return feedbackMapper.toResponse(feedbackRepository.save(feedbackMapper.toFeedback(message, user)));
    }

    @Override
    public List<FeedbackResponse> all(int page, int size) {
        return feedbackMapper.toResponseList(feedbackRepository.findAll(PageRequest.of(page, size)).toList());
    }
}
