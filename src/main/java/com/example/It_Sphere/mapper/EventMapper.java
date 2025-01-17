package com.example.It_Sphere.mapper;

import com.example.It_Sphere.model.domain.Category;
import com.example.It_Sphere.model.domain.Event;
import com.example.It_Sphere.model.dto.event.EventRequest;
import com.example.It_Sphere.model.dto.event.EventResponse;

import java.util.List;

public interface EventMapper {
    Event toEvent(Event event, EventRequest request, Category category);
    EventResponse toResponse(Event event);
    List<EventResponse> toResponseList(List<Event> eventList);
}
