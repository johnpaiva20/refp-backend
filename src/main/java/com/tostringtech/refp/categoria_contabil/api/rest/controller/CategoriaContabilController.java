package com.tostringtech.refp.categoria_contabil.api.rest.controller;

import com.tostringtech.refp.categoria_contabil.api.rest.filters.AccountCategoryFilter;
import com.tostringtech.refp.categoria_contabil.api.service.CategoriaContabilService;
import com.tostringtech.refp.projeto.api.rest.resources.AccountCategoryResource;
import io.swagger.annotations.Api;
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
@Api(tags = {"Account"})
public class CategoriaContabilController {

    @Autowired
    CategoriaContabilService categoriaContabilService;

    @GetMapping(value = "/account-categories")
    @ApiOperation( value = "Listar categorias contabeis")
    public ResponseEntity<List<AccountCategoryResource>> listAllAccountCategoriesByProjectType(AccountCategoryFilter filter) {

        List<AccountCategoryResource> categoriasContabeis = categoriaContabilService
                .listAccountCategories(filter)
                .stream()
                .map(AccountCategoryResource::new)
                .collect(Collectors.toList());

        if (!categoriasContabeis.isEmpty()) {
            return ResponseEntity.ok().body(categoriasContabeis);
        }
        return ResponseEntity.noContent().build();
    }
}
