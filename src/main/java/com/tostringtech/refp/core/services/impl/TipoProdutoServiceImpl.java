package com.tostringtech.refp.core.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tostringtech.refp.core.entities.TipoProduto;
import com.tostringtech.refp.core.services.TipoProdutoService;
import com.tostringtech.refp.repositories.TipoProdutoRepository;

@Service
public class TipoProdutoServiceImpl implements TipoProdutoService {

	@Autowired
	private TipoProdutoRepository tipoProdutoRepositorio;

	@Override
	public TipoProduto create(TipoProduto obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TipoProduto update(TipoProduto obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Long codObj) {
		// TODO Auto-generated method stub

	}

	@Override
	public TipoProduto findByCod(Long codObj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<TipoProduto> findAll() {
		return tipoProdutoRepositorio.findAll();
	}

}
