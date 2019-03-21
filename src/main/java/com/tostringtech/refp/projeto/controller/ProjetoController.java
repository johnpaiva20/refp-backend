package com.tostringtech.refp.projeto.controller;

import com.tostringtech.refp.application.model.Projeto;
import com.tostringtech.refp.projeto.controller.resources.ProjectResource;
import com.tostringtech.refp.projeto.service.ProjetoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/projects")
@Api(tags = "Project", description = "Endpoints de Projeto")
public class ProjetoController {

    private static final Logger logger = Logger.getLogger(ProjetoController.class);

    @Autowired
    private ProjetoService projetoService;

    @PostMapping("")
    @ApiOperation(value = "Cadastrar um novo Projeto ")
    public ResponseEntity<ProjectResource> create(@RequestBody ProjectResource resource) {
        Projeto projeto = projetoService.create(new Projeto(resource));
        resource = new ProjectResource(projeto);
        if (resource != null) {
            return new ResponseEntity<>(resource, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("")
    @ApiOperation(value = "Encontrar todos os Projetos cadastrados")
    public ResponseEntity<List<ProjectResource>> findAll() {

        List<ProjectResource> resources = projetoService
                .findAll()
                .stream()
                .map(ProjectResource::new)
                .collect(Collectors.toList());

        if (!resources.isEmpty()) {
            return new ResponseEntity<>(resources, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Encontrar todos os Projetos cadastrados")
    public ResponseEntity<ProjectResource> findById(@PathVariable Long id) {
        Projeto projeto = projetoService.findById(id).orElse(null);
        ProjectResource resource = new ProjectResource(projeto);

        if (resource != null) {
            return new ResponseEntity<>(resource, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
