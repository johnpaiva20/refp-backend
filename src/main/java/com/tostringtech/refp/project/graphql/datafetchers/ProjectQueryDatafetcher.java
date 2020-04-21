package com.tostringtech.refp.project.graphql.datafetchers;

import com.tostringtech.refp.project.api.resources.ProjectResource;
import com.tostringtech.refp.project.api.service.ProjectService;
import graphql.schema.DataFetcher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

@Component
public class ProjectQueryDatafetcher {

    @Autowired
    private ProjectService projectService;

    public DataFetcher listProjects() {
        return dataFetchingEnvironment -> {
            Pageable pageable =  PageRequest.of(0, 20);
            return projectService.findAll(pageable).stream().map(ProjectResource::new).collect(Collectors.toList());
        };
    }

    public DataFetcher getProject() {
        return dataFetchingEnvironment -> {
            Long id = Long.parseLong(dataFetchingEnvironment.getArgument("id").toString());
            return projectService.findById(id).map(ProjectResource::new);
        };
    }


    public Map<String, DataFetcher> getDataFetcherMap() {

        Map<String, DataFetcher> dataFetcherMap = new HashMap<>();
        dataFetcherMap.put("listProjects", listProjects());
        dataFetcherMap.put("project", getProject());

        return dataFetcherMap;
    }
}
