package com.tostringtech.refp.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

import com.tostringtech.refp.core.entities.Despesa;

public interface DespesaResource {
	public ResponseEntity<Despesa> create(@RequestBody Despesa despesa);
}