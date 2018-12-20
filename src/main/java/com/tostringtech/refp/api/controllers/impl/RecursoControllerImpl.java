package com.tostringtech.refp.api.controllers.impl;

import com.tostringtech.refp.api.controllers.RecursoController;
import com.tostringtech.refp.core.entities.Recurso;
import com.tostringtech.refp.core.services.RecursoProjetoService;
import com.tostringtech.refp.core.services.RecursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/recursos")
public class RecursoControllerImpl implements RecursoController {
	
	@Autowired
	private RecursoService recursoService;
	@Autowired
	private RecursoProjetoService recursoProjetoService;
	@Override
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable Long id) {
		Recurso recurso = recursoService.findByCod(id);
		return ResponseEntity.ok().body(recurso);

	}
	@Override
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<?> findAll() {
		List<Recurso>recursos = recursoService.findAll();
		return ResponseEntity.ok().body(recursos);
	}
	@Override
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<?> create(@RequestBody Recurso recurso) {
		return ResponseEntity.ok().body(recursoService.create(recurso));
	}
	@Override
	@RequestMapping(method = RequestMethod.PUT)
	public ResponseEntity<?> update(@RequestBody Recurso recurso) {
		return ResponseEntity.ok().body(recursoService.update(recurso)) ;
	}

}
