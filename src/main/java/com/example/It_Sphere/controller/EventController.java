package com.example.It_Sphere.controller;

import com.example.It_Sphere.model.dto.event.EventRequest;
import com.example.It_Sphere.model.dto.event.EventResponse;
import com.example.It_Sphere.service.EventService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/events")
public class EventController {
    private final EventService eventService;

    @PostMapping
    public EventResponse create(@RequestBody EventRequest eventRequest, @RequestParam String category) {
        return eventService.create(eventRequest, category);
    }

    @PutMapping("/{id}")
    public EventResponse update(
            @RequestBody EventRequest eventRequest,
            @PathVariable Long id,
            @RequestParam(required = false) String category
    ) {
        return eventService.update(eventRequest, id, category);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        eventService.delete(id);
    }

    @GetMapping
    public List<EventResponse> all(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int pageSize
    ) {
        return eventService.all(page, pageSize);
    }
}
