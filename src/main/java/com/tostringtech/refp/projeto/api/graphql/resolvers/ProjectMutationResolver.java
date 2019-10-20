package com.tostringtech.refp.projeto.api.graphql.resolvers;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.tostringtech.refp.application.models.Projeto;
import com.tostringtech.refp.projeto.api.rest.resources.ProjectResource;
import com.tostringtech.refp.projeto.api.service.ProjetoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProjectMutationResolver implements GraphQLMutationResolver {

    @Autowired
    private ProjetoService projetoService;

    public ProjectResource createProject(ProjectResource project) {
        return new ProjectResource(projetoService.create(new Projeto(project)));
    }
}
