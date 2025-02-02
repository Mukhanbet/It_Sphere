package com.example.It_Sphere.model.dto.project;

import lombok.Data;

import java.util.List;

@Data
public class ProjectRequest {
    private String name;
    private String description;
    private String deploy;
    private String github;
    private List<String> membersEmail;
}

