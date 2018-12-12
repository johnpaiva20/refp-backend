package com.tostringtech.refp.resources.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tostringtech.refp.core.entities.TemaProjeto;
import com.tostringtech.refp.core.services.TemaProjetoService;
import com.tostringtech.refp.resources.TemaProjetoResource;
@RestController
@RequestMapping(value = "/temas-projeto")
public class TemaProjetoResourceImpl implements TemaProjetoResource {

	
	@Autowired
	private TemaProjetoService temaProjetoService;
	@Override
	@GetMapping(value = "")
	public ResponseEntity<?> findAll() {
		List<TemaProjeto> temas = temaProjetoService.findAll();
		return ResponseEntity.ok().body(temas);
	}
}
