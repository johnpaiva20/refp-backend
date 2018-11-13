package com.tostringtech.refp.core.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tostringtech.refp.core.entities.Rubrica;
import com.tostringtech.refp.repositories.RubricaRepository;

@Service
public class RubricaService {

	@Autowired
	private RubricaRepository rubricaRepositorio;

	public Rubrica create(Rubrica rubrica) {
		return rubricaRepositorio.save(rubrica);
	}

	public void delete(Rubrica rubrica) {
		rubricaRepositorio.delete(rubrica);
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
