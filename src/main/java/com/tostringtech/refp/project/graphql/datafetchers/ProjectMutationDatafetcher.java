package com.tostringtech.refp.project.graphql.datafetchers;

import com.tostringtech.refp.application.models.Projeto;
import com.tostringtech.refp.project.api.resources.ProjectResource;
import com.tostringtech.refp.project.api.service.ProjectService;
import graphql.schema.DataFetcher;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

@Component
public class ProjectMutationDatafetcher {

    @Autowired
    private ProjectService projectService;

    final Logger logger = LoggerFactory.getLogger(ProjectMutationDatafetcher.class);

    public DataFetcher createProject() {
        return dataFetchingEnvironment -> {
            LinkedHashMap project = dataFetchingEnvironment.getArgument("project");
            ProjectResource resource = new ProjectResource(project);
            return new ProjectResource(projectService.create(new Projeto(resource)));
        };
    }

    public Map<String, DataFetcher> getDataFetcherMap() {

        Map<String, DataFetcher> dataFetcherMap = new HashMap<>();
        dataFetcherMap.put("createProject", createProject());

        return dataFetcherMap;
    }
}
