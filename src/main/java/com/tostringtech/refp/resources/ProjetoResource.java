package com.tostringtech.refp.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.tostringtech.refp.core.entities.Membro;
import com.tostringtech.refp.core.entities.Projeto;
import com.tostringtech.refp.core.services.ProjetoService;

@RestController
@RequestMapping(value = "/projetos")
public class ProjetoResource {

	@Autowired
	private ProjetoService projetoService;

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable Long id) {
		Projeto p = projetoService.find(id);
		return ResponseEntity.ok().body(p);

	}
	@RequestMapping(value = "", method = RequestMethod.GET)
	public ResponseEntity<?> findAll() {
		List<Projeto>projetos=projetoService.findAll();
		return ResponseEntity.ok().body(projetos);
	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Projeto> create(@RequestBody Projeto projeto) {
		Projeto p = projetoService.create(projeto);
		return ResponseEntity.ok().body(p);
	}
	
	@RequestMapping(value = "/{id}/membros" ,method = RequestMethod.GET)
	public ResponseEntity<?>findAllMembers(@PathVariable Long id){
		List<Membro>membro=projetoService.findAllProjectMembers(id);
		return ResponseEntity.ok().body(membro);
	}
	
}
