package com.tostringtech.refp.api.controllers;

import com.tostringtech.refp.core.entities.Rubrica;
import com.tostringtech.refp.core.services.RubricaService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/accounting-categories")
@Api(tags = "Rubrica")
public class RubricaController {


    @Autowired
    private RubricaService rubricaService;

    ResponseEntity<?> create(Rubrica rubrica) {
        //TODO
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    ResponseEntity<?> delete(Long codRubrica) {
        //TODO
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    ResponseEntity<?> find(Long id) {
        //TODO
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    ResponseEntity<?> findAll() {
        //TODO
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    ResponseEntity<?> update(Rubrica rubrica) {
        //TODO
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


}
