package com.tostringtech.refp.core.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tostringtech.refp.core.entities.RecursoProjeto;
import com.tostringtech.refp.core.repositories.RecursoProjetoRepository;
import com.tostringtech.refp.core.services.RecursoProjetoService;

@Service
public class RecursoProjetoServiceImpl  implements RecursoProjetoService {

	@Autowired
	private RecursoProjetoRepository repository;
	
	
	@Override
	public RecursoProjeto update(RecursoProjeto recursosProj) {
		return repository.save(recursosProj);
	}

	@Override
	public void delete(Long recursosProj) {
		repository.deleteById(recursosProj);
	}

	@Override
	public RecursoProjeto findByCod(Long codRecursoProj) {
		Optional<RecursoProjeto> recursoProj = repository.findById(codRecursoProj);
		return recursoProj .orElse(null);
	}

	@Override
	public List<RecursoProjeto> findAll() {
		return (List<RecursoProjeto>) repository.findAll();
	}

	@Override
	public RecursoProjeto create(RecursoProjeto obj) {
		return repository.save(obj);
	}

}
