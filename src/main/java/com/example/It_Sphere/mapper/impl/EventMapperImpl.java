package com.example.It_Sphere.mapper.impl;

import com.example.It_Sphere.mapper.EventMapper;
import com.example.It_Sphere.model.domain.Category;
import com.example.It_Sphere.model.domain.Event;
import com.example.It_Sphere.model.dto.event.EventRequest;
import com.example.It_Sphere.model.dto.event.EventResponse;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class EventMapperImpl implements EventMapper {
    @Override
    public Event toEvent(Event event, EventRequest request, Category category) {
        event.setTitle(request.getTitle());
        event.setDescription(request.getDescription());
        event.setStartTime(request.getStartTime());
        event.setLocation(request.getLocation());
        event.setCategory(category);
        return event;
    }

    @Override
    public EventResponse toResponse(Event event) {
        EventResponse response = new EventResponse();
        response.setTitle(event.getTitle());
        response.setDescription(event.getDescription());
        response.setStartTime(event.getStartTime());
        response.setLocation(event.getLocation());
        response.setCategory(event.getCategory().getName());
        return response;
    }

    @Override
    public List<EventResponse> toResponseList(List<Event> eventList) {
        List<EventResponse> responseList = new ArrayList<>();
        for (Event event : eventList) {
            responseList.add(toResponse(event));
        }
        return responseList;
    }
}
