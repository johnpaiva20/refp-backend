package com.tostringtech.refp.api.controllers;

import com.tostringtech.refp.core.entities.Recurso;
import com.tostringtech.refp.core.services.RecursoService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/resources")
@Api(tags = "Recurso")
public class RecursoController {

    @Autowired
    private RecursoService recursoService;

    ResponseEntity<?> create(Recurso recurso) {
        //TODO
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    ResponseEntity<?> findAll() {
        //TODO

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    ResponseEntity<?> findById(Long id) {
        //TODO
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    ResponseEntity<?> update(Recurso recurso) {
        //TODO
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
