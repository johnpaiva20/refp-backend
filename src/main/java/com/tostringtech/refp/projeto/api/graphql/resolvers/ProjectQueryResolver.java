package com.tostringtech.refp.projeto.api.graphql.resolvers;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.tostringtech.refp.projeto.api.repository.ProjetoRepository;
import com.tostringtech.refp.projeto.api.rest.resources.ProjectResource;
import com.tostringtech.refp.projeto.api.service.ProjetoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Component
public class ProjectQueryResolver implements GraphQLQueryResolver {

    @Autowired
    private ProjetoService projetoService;

    public List<ProjectResource> allProjects() {
        return projetoService.findAll().stream()
                .map(ProjectResource::new)
                .collect(Collectors.toList());
    }

    public ProjectResource project(Long id) {
        return new ProjectResource(Objects.requireNonNull(projetoService.findById(id).orElse(null)));
    }
}
