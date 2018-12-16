package com.tostringtech.refp.api.controllers;

import org.springframework.http.ResponseEntity;

import com.tostringtech.refp.core.entities.Membro;

public interface MembroResource {

	ResponseEntity<?> findAll();

	ResponseEntity<?> update(Membro membro);

	ResponseEntity<?> findByCodMembro(Long codMmebro);

	ResponseEntity<?> delete(Long codMmebro);

	ResponseEntity<Membro> create(Membro membro);

}
