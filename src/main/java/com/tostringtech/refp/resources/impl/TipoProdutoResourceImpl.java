package com.tostringtech.refp.resources.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tostringtech.refp.core.entities.TipoProduto;
import com.tostringtech.refp.core.services.TipoProdutoService;
import com.tostringtech.refp.resources.TipoProdutoResource;

@RestController
@RequestMapping(value = "/tipo-produtos")
public class TipoProdutoResourceImpl implements TipoProdutoResource {
	
	@Autowired
	private TipoProdutoService tipoProdutoService;
	@Override
	@GetMapping(value = "")
	public ResponseEntity<?> findAll() {
		List<TipoProduto> tiposProdutos = tipoProdutoService.findAll();
		return ResponseEntity.ok().body(tiposProdutos);
	}
	
}
