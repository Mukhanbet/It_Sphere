package com.example.It_Sphere.service;

import com.example.It_Sphere.model.dto.project.ProjectRequest;
import com.example.It_Sphere.model.dto.project.ProjectResponse;

import java.util.List;

public interface ProjectService {
    ProjectResponse create(ProjectRequest projectRequest);
    List<ProjectResponse> all();
    ProjectResponse getProject(Long id);
    ProjectResponse addMember(Long projectId, List<String> emails);
    ProjectResponse removeMember(Long projectId, List<String> emails);
    void deleteProject(Long projectId);
}
