package com.tostringtech.refp.resources;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;

import com.tostringtech.refp.core.entities.Projeto;
import com.tostringtech.refp.core.entities.RecursoProjeto;

public interface ProjetoResource {

	ResponseEntity<?> findAll() throws Exception;

	ResponseEntity<Projeto> create(@Valid Projeto projeto);

	ResponseEntity<?> findById(Long codProjeto);

	ResponseEntity<?> addRecurso(RecursoProjeto recurso);

	ResponseEntity<?> delete(Long codProjeto);

	ResponseEntity<?> update(Projeto projeto);

}
