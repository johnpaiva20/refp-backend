package com.tostringtech.refp.empresa.api.rest.controller;

import com.tostringtech.refp.application.models.Empresa;
import com.tostringtech.refp.empresa.api.rest.resources.EnterpriseResource;
import com.tostringtech.refp.empresa.api.services.EmpresaService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@Api(tags = {"Enterprises"})
public class EnterpriseController {

    @Autowired
    private EmpresaService empresaService;

    @PostMapping("/enterprises")
    @ApiOperation(tags = {"Enterprises"},value = "Cadastrar nova empresa")
    public ResponseEntity<EnterpriseResource> create(@RequestBody EnterpriseResource resource) {
        Empresa empresa = empresaService.create(new Empresa(resource));
        resource = new EnterpriseResource(empresa);
        if (resource != null) {
            return new ResponseEntity<>(resource, HttpStatus.CREATED);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/enterprises")
    @ApiOperation(tags = {"Enterprises"},value = "Encontrar todas as empresas cadastradas")
    public ResponseEntity<List<EnterpriseResource>> findAll(Pageable pageable) {

        List<EnterpriseResource> resources;
        resources = empresaService.findAll()
                .stream()
                .map(EnterpriseResource::new)
                .collect(Collectors.toList());

        if (!resources.isEmpty()) {
            return new ResponseEntity<>(resources, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/enterprises/{id}")
    @ApiOperation(tags = {"Enterprises"},value = "Encontrar Empresa pelo ID")
    public ResponseEntity<EnterpriseResource> findById(@PathVariable Long id) {
        Empresa empresa = empresaService.findById(id).orElse(null);
        EnterpriseResource resource = new EnterpriseResource(empresa);

        if (resource != null) {
            return new ResponseEntity<>(resource, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping(value = "/enterprises/page")
    @ApiOperation(tags = {"Enterprises"},value = "Listar empresas")
    public ResponseEntity<Page<EnterpriseResource>> findPage(
            @RequestParam(value = "page", defaultValue = "0") Integer page,
            @RequestParam(value = "linesPerPage", defaultValue = "24") Integer linesPerPage,
            @RequestParam(value = "orderBy", defaultValue = "descricaoRecurso") String orderBy,
            @RequestParam(value = "direction", defaultValue = "ASC") String direction) {
        Page<Empresa> list = empresaService.findPage(page, linesPerPage, orderBy, direction);
        Page<EnterpriseResource> listDto = list.map(EnterpriseResource::new);
        return ResponseEntity.ok().body(listDto);
    }
}
