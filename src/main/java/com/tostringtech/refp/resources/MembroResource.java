package com.tostringtech.refp.resources;

import java.util.List;

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

import com.tostringtech.refp.core.entities.Membro;
import com.tostringtech.refp.core.services.MembroService;

@RestController
@RequestMapping(value = "/membros")
public class MembroResource {

	@Autowired
	private MembroService membroService;

	@GetMapping(value = "")
	public ResponseEntity<?> findAll() {
		List<Membro> membros = membroService.findAll();
		return ResponseEntity.ok().body(membros);
	}

	@PostMapping(value = "")
	public ResponseEntity<Membro> create(@RequestBody Membro membro) {
		Membro m = membroService.create(membro);
		return ResponseEntity.ok().body(m);
	}

	@PutMapping(value = "")
	public ResponseEntity<?> update(@RequestBody Membro membro) {
		Membro m = membroService.update(membro);
		return ResponseEntity.ok().body(m);
	}

	@DeleteMapping(value = "/{codMmebro}")
	public ResponseEntity<?> delete(@PathVariable Long codMmebro) {
		membroService.delete(codMmebro);
		return ResponseEntity.ok().body("");
	}

	@GetMapping(value = "/{codMmebro}")
	public ResponseEntity<?> findByCodMembro(@PathVariable Long codMmebro) {
		Membro membro = membroService.findByCod(codMmebro);
		return ResponseEntity.ok().body(membro);

	}
}