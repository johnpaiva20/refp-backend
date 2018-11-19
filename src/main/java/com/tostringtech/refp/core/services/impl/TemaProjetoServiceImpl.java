package com.tostringtech.refp.core.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tostringtech.refp.core.entities.TemaProjeto;
import com.tostringtech.refp.core.services.TemaProjetoService;
import com.tostringtech.refp.repositories.TemaProjetoRepository;

@Service
public class TemaProjetoServiceImpl implements TemaProjetoService {

	@Autowired
	private TemaProjetoRepository temaProjetoRepositorio;

	@Override
	public TemaProjeto create(TemaProjeto obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TemaProjeto update(TemaProjeto obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Long codObj) {
		// TODO Auto-generated method stub

	}

	@Override
	public TemaProjeto findByCod(Long codObj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<TemaProjeto> findAll() {
		return temaProjetoRepositorio.findAll();
	}

}
