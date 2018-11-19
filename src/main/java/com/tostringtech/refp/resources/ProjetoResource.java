package com.tostringtech.refp.resources;

import java.util.List;

import javax.validation.Valid;

import org.hibernate.annotations.Parameter;
import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.jsonschema.JsonSerializableSchema;
import com.tostringtech.refp.core.entities.Projeto;
import com.tostringtech.refp.core.entities.Recurso;
import com.tostringtech.refp.core.entities.RecursoProjeto;
import com.tostringtech.refp.core.services.ProjetoService;

@RestController(value="Projetos")
@RequestMapping(value = "/projetos")
public class ProjetoResource  {
	private static final Logger logger = Logger.getLogger(ProjetoResource.class);
	@Autowired
	private ProjetoService projetoService;

	// Projeto
	@GetMapping(value = "")
	public ResponseEntity<?> findAll() throws Exception {
		List<Projeto> projetos = projetoService.findAll();
		return ResponseEntity.ok().body(projetos);
	}

	@PostMapping(value = "", consumes = { MediaType.APPLICATION_JSON_UTF8_VALUE, MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_FORM_URLENCODED_VALUE }, produces = { MediaType.APPLICATION_JSON_UTF8_VALUE })
	public ResponseEntity<Projeto> create(@Valid @RequestBody(required = true) final Projeto projeto) {
		Projeto p = projetoService.create(projeto);
		return ResponseEntity.ok().body(p);
	}

	@PutMapping(value="")
	public ResponseEntity<?> update(@RequestBody() Projeto projeto) {
		return ResponseEntity.ok().body("");
	}
	
	@DeleteMapping(value="/{codProjeto}")
	public ResponseEntity<?> delete(@PathVariable Long codProjeto) {
		return ResponseEntity.ok().body("");
	}
	
	@PostMapping(value = "/recurso")
	public ResponseEntity<?> addRecurso(@RequestBody RecursoProjeto recurso) {
		RecursoProjeto recursoProjeto = projetoService.addRecursoProjeto(recurso);
		return ResponseEntity.ok().body(recursoProjeto);
	}

	@GetMapping(value = "/{codProjeto}")
	public ResponseEntity<?> findById(@PathVariable Long codProjeto) {
		Projeto p = projetoService.findByCod(codProjeto);
		return ResponseEntity.ok().body(p);
	}
}
