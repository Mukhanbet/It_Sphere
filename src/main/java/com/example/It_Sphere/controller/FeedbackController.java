package com.example.It_Sphere.controller;

import com.example.It_Sphere.model.dto.feedback.FeedbackResponse;
import com.example.It_Sphere.service.FeedbackService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/feedbacks")
public class FeedbackController {
    private final FeedbackService feedbackService;

    @PostMapping
    public FeedbackResponse leaveFeedback(
            @RequestParam String message,
            @RequestHeader(name = "Authorization") String token
    ) {
        return feedbackService.leaveFeedback(message, token);
    }

    @GetMapping
    public List<FeedbackResponse> all(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size
    ) {
        return feedbackService.all(page, size);
    }
}
