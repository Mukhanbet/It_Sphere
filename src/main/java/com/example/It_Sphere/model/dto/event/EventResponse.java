package com.example.It_Sphere.model.dto.event;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class EventResponse {
    private String title;
    private String description;
    private LocalDateTime startTime;
    private String location;
    private String category;
}
