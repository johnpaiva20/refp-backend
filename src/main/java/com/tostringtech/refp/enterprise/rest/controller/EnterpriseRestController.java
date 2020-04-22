package com.tostringtech.refp.enterprise.rest.controller;

import com.tostringtech.refp.application.models.Empresa;
import com.tostringtech.refp.application.models.Projeto;
import com.tostringtech.refp.enterprise.api.resources.EnterpriseResource;
import com.tostringtech.refp.enterprise.api.service.EnterpriseService;
import com.tostringtech.refp.project.api.resources.ProjectResource;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@Api(tags = "Enterprise")
public class EnterpriseRestController {

    @Autowired
    private EnterpriseService enterpriseService;

    @PostMapping("/enterprises")
    @ApiOperation(tags = {"Enterprise"}, value = "Cadastrar uma nova Empresa")
    public ResponseEntity<EnterpriseResource> createEnterprise(@RequestBody EnterpriseResource resource) {
        Empresa empresa = enterpriseService.save(new Empresa(resource));
        resource = new EnterpriseResource(empresa);
        return new ResponseEntity<>(resource, HttpStatus.CREATED);
    }

    @GetMapping("/enterprises")
    @ApiOperation(tags = {"Enterprise"}, value = "Listar empresas cadastradas")
    public ResponseEntity<List<EnterpriseResource>> listEnterprises() {

        List<EnterpriseResource> resources = enterpriseService
                .findAll()
                .stream()
                .map(EnterpriseResource::new)
                .collect(Collectors.toList());

        return  new ResponseEntity<>(resources, HttpStatus.OK);
    }

    @GetMapping("/enterprises/{id}")
    @ApiOperation(tags = {"Enterprise"}, value = "Encontrar uma Empresa")
    public ResponseEntity<EnterpriseResource> findProjectById(@PathVariable Long id) {

        Empresa empresa =  enterpriseService.findById(id).orElse(null);

        if(empresa == null){
            return  new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        EnterpriseResource resource = new EnterpriseResource(empresa);
        return new ResponseEntity<>(resource,HttpStatus.FOUND);
    }

    @PutMapping(value = "/enterprises/{id}")
    @ApiOperation(tags = {"Enterprise"}, value = "Atualizar uma Empresa")
    public ResponseEntity<Void> updateProject(@RequestBody EnterpriseResource resoruce, @PathVariable Long id) {
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping(value = "/enterprises/{id}")
    @ApiOperation(tags = {"Enterprise"}, value = "Deletar uma Empresa")
    public ResponseEntity<Void> deleteProject(@PathVariable Long id) {
        return ResponseEntity.noContent().build();
    }

}
