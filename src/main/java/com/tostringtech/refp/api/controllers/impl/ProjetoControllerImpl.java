package com.tostringtech.refp.api.controllers.impl;

import java.util.List;

import javax.validation.Valid;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tostringtech.refp.api.controllers.ProjetoController;
import com.tostringtech.refp.core.entities.FaseCadeiaInovacaoProjeto;
import com.tostringtech.refp.core.entities.Projeto;
import com.tostringtech.refp.core.entities.RecursoProjeto;
import com.tostringtech.refp.core.entities.SegmentoProjeto;
import com.tostringtech.refp.core.services.ProjetoService;

import io.swagger.annotations.Api;

@RestController(value = "Projetos")
@RequestMapping(value = "/projetos")
@Api(tags="Projeto")
public class ProjetoControllerImpl implements ProjetoController {
	private static final Logger logger = Logger.getLogger(ProjetoControllerImpl.class);
	@Autowired
	private ProjetoService projetoService;

	// Projeto
	@Override
	@GetMapping(value = "")
	public ResponseEntity<?> findAll() throws Exception {
		logger.info("Finding all Projects");
		List<Projeto> projetos = projetoService.findAll();
		return ResponseEntity.ok().body(projetos);

	}

	@Override
	@PostMapping(value = "")
	public ResponseEntity<Projeto> create(@Valid @RequestBody(required = true) final Projeto projeto) {
		Projeto p = projetoService.create(projeto);
		return ResponseEntity.ok().body(p);
	}
	@Override
	@PutMapping(value = "")
	public ResponseEntity<?> update(@RequestBody() Projeto projeto) {
		return ResponseEntity.ok().body("");
	}
	@Override
	@DeleteMapping(value = "/{codProjeto}")
	public ResponseEntity<?> delete(@PathVariable Long codProjeto) {
		return ResponseEntity.ok().body("");
	}
	@Override
	@PostMapping(value = "/recurso")
	public ResponseEntity<?> addRecurso(@RequestBody RecursoProjeto recurso) {
		RecursoProjeto recursoProjeto = projetoService.addRecursoProjeto(recurso);
		return ResponseEntity.ok().body(recursoProjeto);
	}
	@Override
	@GetMapping(value = "/{codProjeto}")
	public ResponseEntity<?> findById(@PathVariable Long codProjeto) {
		Projeto p = projetoService.findByCod(codProjeto);
		return ResponseEntity.ok().body(p);
	}
	
	@Override
	@GetMapping(value = "/segmentos")
	public ResponseEntity<?> findAllProjectSegments() {
		List<SegmentoProjeto> segmentos = projetoService.findAllProjectSegments();
		return ResponseEntity.ok().body(segmentos);
	}

	@Override
	@GetMapping(value = "/inovation-phases")
	public ResponseEntity<?> findAllProjectInovationPhases() {
		List<FaseCadeiaInovacaoProjeto>fasesInovacao=projetoService.findAllProjectInovationPhases();
		return ResponseEntity.ok().body(fasesInovacao);
	}
}
