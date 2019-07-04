package com.tostringtech.refp.categoria_contabil.api.rest.controller;

import com.tostringtech.refp.categoria_contabil.api.service.CategoriaContabilService;
import com.tostringtech.refp.projeto.api.rest.resources.AccountCategoryResource;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class CategoriaContabilController {

    @Autowired
    CategoriaContabilService categoriaContabilService;

    @GetMapping("/account-categories/{type}")
    @ApiOperation(tags = {"Account"},value = "Encontrar todos as categorias cadastrados")
    public ResponseEntity<List<AccountCategoryResource>> findAllByProjectType(@PathVariable String type) {

        List<AccountCategoryResource> resources = categoriaContabilService
                .findAllByProjectType(type)
                .stream()
                .map(AccountCategoryResource::new)
                .collect(Collectors.toList());

        if (!resources.isEmpty()) {
            return new ResponseEntity<>(resources, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
