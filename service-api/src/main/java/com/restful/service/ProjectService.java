package com.restful.service;

import com.restful.model.Project;

import java.util.List;
import java.util.Optional;

public interface ProjectService {

    List<Project> getAllProjects();

    Project saveOrUpdateProject(Project project);

    Optional<Project> getProjectByName(String projectName);

    Optional<Project> getProjectById(Long projectId);

    void deleteProjectById(Long projectId);
}
