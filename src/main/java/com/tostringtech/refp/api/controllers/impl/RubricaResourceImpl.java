package com.tostringtech.refp.api.controllers.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.tostringtech.refp.api.controllers.RubricaResource;
import com.tostringtech.refp.core.entities.Rubrica;
import com.tostringtech.refp.core.services.RubricaService;

@RestController
@RequestMapping(value = "/rubricas")
public class RubricaResourceImpl implements RubricaResource {


	@Autowired
	private RubricaService rubricaService;
	@Override
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable Long id) {
		Rubrica rubrica = rubricaService.findByCod(id);
		return ResponseEntity.ok().body(rubrica);

	}
	@Override
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<?> findAll() {
		List<Rubrica>rubricas = rubricaService.findAll();
		return ResponseEntity.ok().body(rubricas);
	}
	@Override
	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<?> create(@RequestBody Rubrica rubrica) {
		return ResponseEntity.ok().body(rubricaService.create(rubrica));
	}
	
	@Override
	@RequestMapping(method = RequestMethod.PUT)
	public ResponseEntity<?> update(@RequestBody Rubrica rubrica) {
		return ResponseEntity.ok().body(rubricaService.update(rubrica)) ;
	}
	@Override
	@RequestMapping(method = RequestMethod.DELETE)
	public ResponseEntity<?> delete(@RequestBody Long codRubrica) {
		rubricaService.delete(codRubrica);
		return (ResponseEntity<?>)ResponseEntity.ok() ;
	}
}
