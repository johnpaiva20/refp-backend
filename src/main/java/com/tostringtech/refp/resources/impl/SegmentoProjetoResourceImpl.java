package com.tostringtech.refp.resources.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tostringtech.refp.core.entities.SegmentoProjeto;
import com.tostringtech.refp.core.services.SegmentoProjetoService;
import com.tostringtech.refp.resources.SegmentoResource;

@RestController
@RequestMapping(value = "/segmentos-projeto")
public class SegmentoProjetoResourceImpl implements SegmentoResource {
	@Autowired
	private SegmentoProjetoService segmentoProjetoService;
	@Override
	@GetMapping(value = "")
	public ResponseEntity<?> findAll() {
		List<SegmentoProjeto> segmentos = segmentoProjetoService.findAll();
		return ResponseEntity.ok().body(segmentos);
	}
}
