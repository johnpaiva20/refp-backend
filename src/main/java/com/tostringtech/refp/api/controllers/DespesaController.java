package com.tostringtech.refp.api.controllers;

import com.tostringtech.refp.api.resources.ExpenseResource;
import com.tostringtech.refp.core.services.DespesaService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/expenses")
@Api(tags = "Despesa")
public class DespesaController {

    @Autowired
    private DespesaService despesaService;

    //@PostMapping(value = "")
    ResponseEntity<ExpenseResource> create(@RequestBody ExpenseResource expense) {
        //TODO
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
