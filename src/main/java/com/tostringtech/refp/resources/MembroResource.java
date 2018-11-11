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
import com.tostringtech.refp.core.services.MembroService;


@RestController
@RequestMapping(value = "/membros")
public class MembroResource {

	@Autowired
	private MembroService membroService;

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable Long id) {
		Membro membro = membroService.find(id);
		return ResponseEntity.ok().body(membro);

	}
	@RequestMapping(value = "", method = RequestMethod.GET)
	public ResponseEntity<?> findAll() {
		List<Membro>membros=membroService.findAll();
		return ResponseEntity.ok().body(membros);
	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Membro> create(@RequestBody Membro membro) {
		Membro m = membroService.create(membro);
		return ResponseEntity.ok().body(m);
	}
	
}