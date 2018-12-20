package com.tostringtech.refp.api.controllers.impl;

import com.tostringtech.refp.api.controllers.MembroController;
import com.tostringtech.refp.core.entities.Membro;
import com.tostringtech.refp.core.services.MembroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/membros")
public class MembroControllerImpl implements MembroController {

	@Autowired
	private MembroService membroService;
    
	@Override
	@GetMapping(value = "")
	public ResponseEntity<?> findAll() {
		List<Membro> membros = membroService.findAll();
		return ResponseEntity.ok().body(membros);
	}
	@Override
	@PostMapping(value = "")
	public ResponseEntity<Membro> create(@RequestBody Membro membro) {
		Membro m = membroService.create(membro);
		return ResponseEntity.ok().body(m);
	}
	@Override
	@PutMapping(value = "")
	public ResponseEntity<?> update(@RequestBody Membro membro) {
		Membro m = membroService.update(membro);
		return ResponseEntity.ok().body(m);
	}
	@Override
	@DeleteMapping(value = "/{codMmebro}")
	public ResponseEntity<?> delete(@PathVariable Long codMmebro) {
		membroService.delete(codMmebro);
		return ResponseEntity.ok().body("");
	}
	@Override
	@GetMapping(value = "/{codMmebro}")
	public ResponseEntity<?> findByCodMembro(@PathVariable Long codMmebro) {
		Membro membro = membroService.findByCod(codMmebro);
		return ResponseEntity.ok().body(membro);

	}
}