package com.example.It_Sphere.mapper.impl;

import com.example.It_Sphere.mapper.ProjectMapper;
import com.example.It_Sphere.model.domain.Project;
import com.example.It_Sphere.model.domain.User;
import com.example.It_Sphere.model.dto.project.ProjectRequest;
import com.example.It_Sphere.model.dto.project.ProjectResponse;
import com.example.It_Sphere.model.dto.user.MemberResponse;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Component
public class ProjectMapperImpl implements ProjectMapper {
    @Override
    public Project toProject(ProjectRequest request, Set<User> members) {
        Project project = new Project();
        project.setName(request.getName());
        project.setDescription(request.getDescription());
        if (request.getDeploy() != null) {
            project.setDeploy(request.getDeploy());
        }
        if (request.getGithub() != null) {
            project.setGithub(request.getGithub());
        }
        project.setMembers(members);

        return project;
    }

    @Override
    public ProjectResponse toResponse(Project project) {
        ProjectResponse response = new ProjectResponse();
        response.setName(project.getName());
        response.setDescription(project.getDescription());
        if (project.getDeploy() != null) {
            response.setDeploy(project.getDeploy());
        }
        if (project.getGithub() != null) {
            response.setGithub(project.getGithub());
        }


        // todo: Create userMapper and take it from there
        List<MemberResponse> memberResponses = new ArrayList<>();
        for (User member : project.getMembers()) {
            MemberResponse memberResponse = new MemberResponse();
            memberResponse.setName(member.getName());
            memberResponse.setEmail(member.getEmail());
            memberResponses.add(memberResponse);
        }
        response.setMembers(memberResponses);

        return response;
    }

    @Override
    public List<ProjectResponse> toResponses(List<Project> projects) {
        List<ProjectResponse> responses = new ArrayList<>();
        for (Project project : projects) {
            responses.add(toResponse(project));
        }
        return responses;
    }
}
