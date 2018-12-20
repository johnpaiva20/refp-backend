package com.tostringtech.refp.api.controllers.impl;

import com.tostringtech.refp.api.controllers.DespesaController;
import com.tostringtech.refp.core.entities.Despesa;
import com.tostringtech.refp.core.services.DespesaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/despesas")
public class DespesaControllerImpl implements DespesaController {
	
	@Autowired
	private DespesaService despesaService;
    
	@Override
	@PostMapping(value = "")
	public ResponseEntity<Despesa> create(@RequestBody Despesa despesa) {
		Despesa d =despesaService.create(despesa);
		return ResponseEntity.ok().body(d);
	}
}
