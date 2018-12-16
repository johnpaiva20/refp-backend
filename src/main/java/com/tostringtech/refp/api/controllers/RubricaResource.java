package com.tostringtech.refp.api.controllers;

import org.springframework.http.ResponseEntity;

import com.tostringtech.refp.core.entities.Rubrica;

public interface RubricaResource {

	ResponseEntity<?> update(Rubrica rubrica);

	ResponseEntity<?> delete(Long codRubrica);

	ResponseEntity<?> create(Rubrica rubrica);

	ResponseEntity<?> findAll();

	ResponseEntity<?> find(Long id);

}
