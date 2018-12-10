package com.tostringtech.refp.resources.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tostringtech.refp.core.entities.Despesa;
import com.tostringtech.refp.core.services.DespesaService;
import com.tostringtech.refp.resources.DespesaResource;

@RestController
@RequestMapping(value = "/despesas")
public class DespesaResourceImpl implements DespesaResource {
	
	@Autowired
	private DespesaService despesaService;
    
	@Override
	@PostMapping(value = "")
	public ResponseEntity<Despesa> create(@RequestBody Despesa despesa) {
		Despesa d =despesaService.create(despesa);
		return ResponseEntity.ok().body(d);
	}
}
