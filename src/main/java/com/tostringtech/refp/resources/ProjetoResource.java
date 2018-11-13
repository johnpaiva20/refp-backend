package com.tostringtech.refp.resources;

import java.util.List;

import javax.validation.Valid;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.tostringtech.refp.core.entities.Membro;
import com.tostringtech.refp.core.entities.Projeto;
import com.tostringtech.refp.core.services.ProjetoService;

@RestController
@RequestMapping(value = "/projetos")
public class ProjetoResource {
	private static final Logger logger = Logger.getLogger(ProjetoResource.class);
	@Autowired
	private ProjetoService projetoService;

	// Projeto
	@RequestMapping(value = "", method = RequestMethod.GET)
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

	@RequestMapping(method = RequestMethod.DELETE)
	public ResponseEntity<?> delete(@RequestBody Projeto projeto) {
		return ResponseEntity.ok().body("");
	}

	@RequestMapping(method = RequestMethod.PUT)
	public ResponseEntity<?> update(@RequestBody Projeto projeto) {
		return ResponseEntity.ok().body("");
	}

	@RequestMapping(value = "/{codProjeto}", method = RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable Long codProjeto) {
		Projeto p = projetoService.findByCodProjeto(codProjeto);
		return ResponseEntity.ok().body(p);
	}

	// Membros Projeto
	@RequestMapping(value = "/{codProjeto}/membros", method = RequestMethod.GET)
	public ResponseEntity<?> findAllMembers(@PathVariable Long codProjeto) {
		List<Membro> membro = projetoService.findAllProjectMembers(codProjeto);
		return ResponseEntity.ok().body(membro);
	}

	@RequestMapping(value = "/{codProjeto}/membros", method = RequestMethod.POST)
	public ResponseEntity<?> addMember(@PathVariable Long codProjeto, @RequestBody Long codMembro,
			@RequestBody String descTitulacao) {
		projetoService.addProjectMember(codMembro, codProjeto, descTitulacao);
		return ResponseEntity.ok().body("");
	}

}
