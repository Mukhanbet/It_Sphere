package com.example.It_Sphere.model.dto.project;

import com.example.It_Sphere.model.dto.user.MemberResponse;
import lombok.Data;

import java.util.List;

@Data
public class ProjectResponse {
    private String name;
    private String description;
    private String deploy;
    private String github;
    private List<MemberResponse> members;
}
