package com.example.It_Sphere.controller;

import com.example.It_Sphere.model.dto.project.ProjectRequest;
import com.example.It_Sphere.model.dto.project.ProjectResponse;
import com.example.It_Sphere.service.ProjectService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/projects")
@CrossOrigin(origins = "*", maxAge = 3600)
public class ProjectController {
    private final ProjectService projectService;

    @PostMapping
    public ProjectResponse create(@RequestBody ProjectRequest projectRequest) {
        return projectService.create(projectRequest);
    }

    @GetMapping
    public List<ProjectResponse> all() {
        return projectService.all();
    }

    @GetMapping("/{id}")
    public ProjectResponse getProject(@PathVariable Long id) {
        return projectService.getProject(id);
    }

    @PutMapping("/add-members/{projectId}")
    public ProjectResponse addMember(
            @PathVariable Long projectId,
            @RequestBody List<String> emails
    ) {
        return projectService.addMember(projectId, emails);
    }

    @PutMapping("/remove-members/{projectId}")
    public ProjectResponse removeMember(
            @PathVariable Long projectId,
            @RequestBody List<String> emails
    ) {
        return projectService.removeMember(projectId, emails);
    }

    @DeleteMapping("/{projectId}")
    public void deleteProject(@PathVariable Long projectId) {
        projectService.deleteProject(projectId);
    }
}

