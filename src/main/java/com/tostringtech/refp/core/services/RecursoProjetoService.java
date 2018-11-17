package com.tostringtech.refp.core.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tostringtech.refp.core.entities.RecursoProjeto;
import com.tostringtech.refp.repositories.RecursoProjetoRepository;

@Service
public class RecursoProjetoService  implements IServices<RecursoProjeto> {

	@Autowired
	private RecursoProjetoRepository repository;
	
	@Override
	public RecursoProjeto create(RecursoProjeto recursoProj) {
		RecursoService rs = new RecursoService();
		recursoProj.setRecurso( rs.create(recursoProj.getRecurso()) );
		return repository.save(recursoProj);
	}

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

}
