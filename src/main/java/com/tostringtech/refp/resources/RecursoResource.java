package com.tostringtech.refp.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.tostringtech.refp.core.entities.Recurso;
import com.tostringtech.refp.core.services.RecursoProjetoService;
import com.tostringtech.refp.core.services.RecursoService;

@RestController
@RequestMapping(value = "/recursos")
public class RecursoResource {
	
	@Autowired
	private RecursoService recursoService;
	@Autowired
	private RecursoProjetoService recursoProjetoService;

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable Long id) {
		Recurso recurso = recursoService.findByCod(id);
		return ResponseEntity.ok().body(recurso);

	}
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<?> findAll() {
		List<Recurso>recursos = recursoService.findAll();
		return ResponseEntity.ok().body(recursos);
	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<?> create(@RequestBody Recurso recurso) {
		return ResponseEntity.ok().body(recursoService.create(recurso));
	}
	
	@RequestMapping(method = RequestMethod.PUT)
	public ResponseEntity<?> update(@RequestBody Recurso recurso) {
		return ResponseEntity.ok().body(recursoService.update(recurso)) ;
	}

}
