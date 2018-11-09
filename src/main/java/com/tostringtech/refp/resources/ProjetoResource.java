package com.tostringtech.refp.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.tostringtech.refp.core.entities.Projeto;
import com.tostringtech.refp.core.services.ProjetoService;

@RestController
@RequestMapping(value="/projetos/")
public class ProjetoResource {

	@Autowired
	private ProjetoService projetoService;
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable Long id) {
		Projeto p = projetoService.find(id);
		return ResponseEntity.ok().body(p);
		
	}
}
