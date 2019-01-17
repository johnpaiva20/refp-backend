package com.tostringtech.refp.core.services.impl;

import com.tostringtech.refp.core.repositories.RecursoRepository;
import com.tostringtech.refp.core.services.RecursoService;
import com.tostringtech.refp.core.entities.Recurso;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RecursoServiceImpl implements RecursoService {

	@Autowired
	private RecursoRepository recursoRepository;

	@Override
	public Recurso create(Recurso recurso) {
		return recursoRepository.save(recurso);
	}

	@Override
	public Recurso update(Recurso recurso) {
		return recursoRepository.save(recurso);
	}

	@Override
	public void delete(Long codRubrica) {
		recursoRepository.deleteById(codRubrica);
	}

	@Override
	public Recurso findByCod(Long codRecurso) {
		Optional<Recurso> recurso = recursoRepository.findById(codRecurso);
		return recurso.orElse(null);
	}

	@Override
	public List<Recurso> findAll() {
		return (List<Recurso>) recursoRepository.findAll();
	}
	

}
