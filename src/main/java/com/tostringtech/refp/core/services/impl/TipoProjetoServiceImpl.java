package com.tostringtech.refp.core.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tostringtech.refp.core.entities.TipoProjeto;
import com.tostringtech.refp.core.services.TipoProjetoService;
import com.tostringtech.refp.repositories.TipoProjetoRepository;

@Service
public class TipoProjetoServiceImpl implements TipoProjetoService {

	@Autowired
	private TipoProjetoRepository tipoProjetoRepository;

	@Override
	public List<TipoProjeto> findAll() {
		return tipoProjetoRepository.findAll();

	}
}
