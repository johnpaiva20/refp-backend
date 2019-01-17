package com.tostringtech.refp.core.services.impl;

import com.tostringtech.refp.core.repositories.RubricaRepository;
import com.tostringtech.refp.core.services.RubricaService;
import com.tostringtech.refp.core.entities.Rubrica;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RubricaServiceImpl implements RubricaService {

	@Autowired
	private RubricaRepository rubricaRepositorio;

	
	public Rubrica create(Rubrica rubrica) {
		return rubricaRepositorio.save(rubrica);
	}

	public void delete(Long codRubrica) {
		rubricaRepositorio.deleteById(codRubrica);
	}

	public Rubrica update(Rubrica rubrica) {
		return rubricaRepositorio.save(rubrica);
	}

	public Rubrica findByCod(Long codRubrica) {
		Optional<Rubrica> rubrica = rubricaRepositorio.findById(codRubrica);
		return rubrica.orElse(null);
	}

	public List<Rubrica> findAll() {
		return (List<Rubrica>) rubricaRepositorio.findAll();
	}

	

	

}
