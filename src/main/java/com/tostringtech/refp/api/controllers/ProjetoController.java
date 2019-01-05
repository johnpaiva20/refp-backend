package com.tostringtech.refp.api.controllers;

import javax.validation.Valid;

import com.tostringtech.refp.core.entities.Recurso;
import org.springframework.http.ResponseEntity;

import com.tostringtech.refp.core.entities.Projeto;


public interface ProjetoController {

	ResponseEntity<?> findAll() throws Exception;

	ResponseEntity<Projeto> create(@Valid Projeto projeto);

	ResponseEntity<?> findById(Long codProjeto);

	ResponseEntity<?> delete(Long codProjeto);

	ResponseEntity<?> update(Projeto projeto);
	
	ResponseEntity<?> findAllSegments();
	
	ResponseEntity<?> findAllInovationPhases();

	ResponseEntity<?> findAllTypes();

	ResponseEntity<?> findAllSubjects();

	ResponseEntity<?> findAllSubSubjects( String codTema);

	ResponseEntity<?> findAllResources(Long codProjeto);

	ResponseEntity<?> addResource(Long codProjeto, Recurso recurso);

	ResponseEntity<?> findAllMembers(Long codProjeto);

	ResponseEntity<?> findAllExpenses(Long codProjeto);

	ResponseEntity<?> findAllEnterprises(Long codProjeto);

	ResponseEntity<?> findAllProductTypes();
}
