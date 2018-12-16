package com.tostringtech.refp.core.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tostringtech.refp.core.entities.Despesa;
import com.tostringtech.refp.core.repositories.DespesaRepository;
import com.tostringtech.refp.core.services.DespesaService;

@Service
public class DespesaServiceImpl implements DespesaService {

	@Autowired
	private DespesaRepository despesaRepositorio;

	@Override
	public Despesa create(Despesa despesa) {
		return despesaRepositorio.save(despesa);
	}

	@Override
	public Despesa update(Despesa obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Long codObj) {
		// TODO Auto-generated method stub

	}

	@Override
	public Despesa findByCod(Long codObj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Despesa> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
