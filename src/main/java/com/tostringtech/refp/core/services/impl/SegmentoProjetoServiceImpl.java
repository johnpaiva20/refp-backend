package com.tostringtech.refp.core.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tostringtech.refp.core.entities.SegmentoProjeto;
import com.tostringtech.refp.core.services.SegmentoProjetoService;
import com.tostringtech.refp.repositories.SegmentoProjetoRepository;

@Service
public class SegmentoProjetoServiceImpl implements SegmentoProjetoService {

	@Autowired
	private SegmentoProjetoRepository segmentoProjetoRepositorio;

	@Override
	public SegmentoProjeto create(SegmentoProjeto obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SegmentoProjeto update(SegmentoProjeto obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Long codObj) {
		// TODO Auto-generated method stub

	}

	@Override
	public SegmentoProjeto findByCod(Long codObj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<SegmentoProjeto> findAll() {
		return segmentoProjetoRepositorio.findAll();
	}

}
