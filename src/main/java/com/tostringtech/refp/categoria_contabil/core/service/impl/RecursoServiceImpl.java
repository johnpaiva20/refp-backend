package com.tostringtech.refp.categoria_contabil.core.service.impl;

import com.tostringtech.refp.application.exceptions.ObjectNotFoundException;
import com.tostringtech.refp.application.model.Recurso;
import com.tostringtech.refp.categoria_contabil.api.repository.RecursoRepository;
import com.tostringtech.refp.categoria_contabil.api.service.RecursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RecursoServiceImpl implements RecursoService {

	@Autowired
	private RecursoRepository recursoRepository;

	@Override
	public Recurso findByCod(Long codigo) {
		Optional<Recurso> recurso = recursoRepository.findById(codigo);
		return recurso.orElseThrow( () -> new ObjectNotFoundException("Objeto não encontrado."));
	}

	@Override
	public Page<Recurso> findPage(Integer page, Integer linesPerPage, String orderBy, String direction) {
		return null;
	}

	@Override
	public Recurso create (Recurso recurso){
		return recursoRepository.save(recurso);
	}

	public Recurso update (Recurso recurso) {
		findByCod(recurso.getCodigo());
		return recursoRepository.save(recurso);
	}
	@Override
	public void delete(Long codigo)  {
		findByCod(codigo);
		recursoRepository.deleteById(codigo);
	}
	/*@Override
	public List<Recurso> findAll() {
		return recursoRepository.findAll();
	}

	@Override
	public Page<Recurso> findPage(Integer page, Integer linesPerPage, String orderBy, String direction){
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Sort.Direction.valueOf(direction), orderBy);
		return recursoRepository.findAll(pageRequest);
	}*/



}
