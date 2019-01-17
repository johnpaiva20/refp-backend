package com.tostringtech.refp.api.controllers;

import com.tostringtech.refp.api.resources.EnterpriseResource;
import com.tostringtech.refp.core.services.EmpresaService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/enterprises")
@Api(tags = "Empresa")
public class EnterpriseController {

    @Autowired
    private EmpresaService empresaService;


    @PostMapping("")
    @ApiOperation(value = "Cadastrar uma nova Empresa ")
    public ResponseEntity<EnterpriseResource> create(@RequestBody EnterpriseResource enterpriseResource) {
        EnterpriseResource resource = empresaService.create(enterpriseResource);
        if (resource != null) {
            return new ResponseEntity<>(resource, HttpStatus.CREATED);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
