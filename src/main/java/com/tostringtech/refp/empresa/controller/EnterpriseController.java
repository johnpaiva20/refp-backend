package com.tostringtech.refp.empresa.controller;

import com.tostringtech.refp.application.model.Empresa;
import com.tostringtech.refp.application.model.Projeto;
import com.tostringtech.refp.empresa.controller.resources.EnterpriseResource;
import com.tostringtech.refp.empresa.service.EmpresaService;
import com.tostringtech.refp.projeto.controller.resources.ProjectResource;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/enterprises")
@Api(tags = "Enterprise")
public class EnterpriseController {

    @Autowired
    private EmpresaService empresaService;


    @PostMapping("")
    @ApiOperation(value = "Cadastrar uma nova Empresa ")
    public ResponseEntity<EnterpriseResource> create(@RequestBody EnterpriseResource resource) {
        Empresa empresa = empresaService.create(new Empresa(resource));
        resource = new EnterpriseResource(empresa);
        if (resource != null) {
            return new ResponseEntity<>(resource, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("")
    @ApiOperation(value = "Encontrar todas as Empresas cadastradas")
    public ResponseEntity<List<EnterpriseResource>> findAll() {

        List<EnterpriseResource> resources = empresaService
                .findAll()
                .stream()
                .map(EnterpriseResource::new)
                .collect(Collectors.toList());

        if (!resources.isEmpty()) {
            return new ResponseEntity<>(resources, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }


}
