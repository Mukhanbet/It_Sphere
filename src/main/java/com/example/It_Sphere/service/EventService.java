package com.example.It_Sphere.service;

import com.example.It_Sphere.model.dto.event.EventRequest;
import com.example.It_Sphere.model.dto.event.EventResponse;

import java.util.List;

public interface EventService {
    EventResponse create(EventRequest eventRequest, String category);
    EventResponse update(EventRequest eventRequest, Long id, String category);
    void delete(Long id);
    List<EventResponse> all(int page, int pageSize);
}
