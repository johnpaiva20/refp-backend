package com.tostringtech.refp.resources;

import org.springframework.http.ResponseEntity;

import com.tostringtech.refp.core.entities.Recurso;

public interface RecursoResource {

	ResponseEntity<?> find(Long id);

	ResponseEntity<?> findAll();

	ResponseEntity<?> create(Recurso recurso);

	ResponseEntity<?> update(Recurso recurso);

}
