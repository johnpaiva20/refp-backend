package com.tostringtech.refp.project.rest.controller;

import com.tostringtech.refp.application.models.EmpPro;
import com.tostringtech.refp.application.models.Projeto;
import com.tostringtech.refp.project.api.resources.ProjectEnterpriseResource;
import com.tostringtech.refp.project.api.resources.ProjectResource;
import com.tostringtech.refp.project.api.service.ProjectService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@RestController()
@Api(tags = "Project")
public class ProjectRestController {

    private static final Logger logger = Logger.getLogger(ProjectRestController.class);

    @Autowired
    private ProjectService projectService;

    @PostMapping("/projects")
    @ApiOperation(tags = {"Project"}, value = "Cadastrar um novo Projeto ")
    public ResponseEntity<ProjectResource> createProject(@RequestBody ProjectResource resource) {
        Projeto projeto = projectService.create(new Projeto(resource));
        resource = new ProjectResource(projeto);
        return new ResponseEntity<>(resource, HttpStatus.CREATED);
    }

    @GetMapping("/projects")
    @ApiOperation(tags = {"Project"}, value = "Listar projetos cadastrados")
    public ResponseEntity<List<ProjectResource>> listProjects(Pageable pageable) {

        List<ProjectResource> resources = projectService
                .findAll(pageable)
                .stream()
                .map(ProjectResource::new)
                .collect(Collectors.toList());

        if (!resources.isEmpty()) {
            return new ResponseEntity<>(resources, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/projects/{id}")
    @ApiOperation(tags = {"Project"}, value = "Encontrar um Projeto")
    public ResponseEntity<ProjectResource> findProjectById(@PathVariable Long id) {
        Projeto projeto = projectService.findById(id).orElse(null);
        ProjectResource resource = new ProjectResource(projeto);

        if (resource != null) {
            return new ResponseEntity<>(resource, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping(value = "/projects/{id}")
    @ApiOperation(tags = {"Project"}, value = "Atualizar um Projeto")
    public ResponseEntity<Void> updateProject(@RequestBody ProjectResource resoruce, @PathVariable Long id) {
        Projeto projeto = new Projeto();
        projeto.setCodigo(id);
        projeto = projectService.update(projeto);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping(value = "/projects/{id}")
    @ApiOperation(tags = {"Project"}, value = "Deletar um Projeto")
    public ResponseEntity<Void> deleteProject(@PathVariable Long id) {
        Projeto projeto = new Projeto();
        projeto.setCodigo(id);
        projeto = projectService.delete(projeto);
        return ResponseEntity.noContent().build();
    }

    @PostMapping(value = "/projects/{id}/enterprises")
    @ApiOperation(tags = {"Project"}, value = "Adicionar Empresas")
    public ResponseEntity<List<ProjectEnterpriseResource>> addEnterprises(@PathVariable Long id, @RequestBody List<ProjectEnterpriseResource> resources) {
        List<EmpPro> empresas = resources.stream().map(EmpPro::new).collect(Collectors.toList());
        projectService.addEnterprises(empresas, id);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping(value = "/projects/{id}/enterprises")
    @ApiOperation(tags = {"Project"}, value = "Listar Empresas do Projeto")
    public ResponseEntity<List<ProjectEnterpriseResource>> listProjectEnterprises(@PathVariable Long id) {
        List<ProjectEnterpriseResource> resources = projectService
                .findAllProjectEnterprises(id)
                .stream()
                .map(ProjectEnterpriseResource::new)
                .collect(Collectors.toList());
        return new ResponseEntity<>(resources, HttpStatus.OK);
    }
}
