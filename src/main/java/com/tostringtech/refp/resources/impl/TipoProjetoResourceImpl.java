package com.tostringtech.refp.resources.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tostringtech.refp.core.entities.TipoProjeto;
import com.tostringtech.refp.core.services.TipoProjetoService;
import com.tostringtech.refp.resources.TipoProjetoResource;

@RestController
@RequestMapping(value = "/tipos-projeto")
public class TipoProjetoResourceImpl implements TipoProjetoResource {
	
	@Autowired
	private TipoProjetoService tipoProjetoService;
	
	@Override
	@GetMapping(value="")
	public ResponseEntity<?> findAll() {
		List<TipoProjeto> tiposProjeto = tipoProjetoService.findAll();
		return ResponseEntity.ok().body(tiposProjeto);
	}
}
