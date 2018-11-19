package com.tostringtech.refp.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tostringtech.refp.core.entities.TipoProduto;
import com.tostringtech.refp.core.services.TipoProdutoService;

@RestController
@RequestMapping(value = "/tipo-produtos")
public class TipoProdutoResource {
	
	@Autowired
	private TipoProdutoService tipoProdutoService;

	@GetMapping(value = "")
	public ResponseEntity<?> findAll() {
		List<TipoProduto> tiposProdutos = tipoProdutoService.findAll();
		return ResponseEntity.ok().body(tiposProdutos);
	}
	
}
