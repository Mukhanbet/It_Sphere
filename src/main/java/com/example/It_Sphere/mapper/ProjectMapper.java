package com.example.It_Sphere.mapper;

import com.example.It_Sphere.model.domain.Project;
import com.example.It_Sphere.model.domain.User;
import com.example.It_Sphere.model.dto.project.ProjectRequest;
import com.example.It_Sphere.model.dto.project.ProjectResponse;

import java.util.List;
import java.util.Set;

public interface ProjectMapper {
    Project toProject(ProjectRequest request, Set<User> members);
    ProjectResponse toResponse(Project project);
    List<ProjectResponse> toResponses(List<Project> projects);
}
