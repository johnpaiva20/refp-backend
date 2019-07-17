package com.tostringtech.refp.projeto.core.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.tostringtech.refp.application.model.Subtema;
import com.tostringtech.refp.projeto.api.repository.SubtemaRepository;
import com.tostringtech.refp.projeto.api.service.SubtemaService;

public class SubtemaServiceImpl implements SubtemaService {
	
	@Autowired
	SubtemaRepository subtemaRepository;
	
	@Override
	public Subtema create(Subtema subtema) {
		//garantindo que realmente algo 
		//novo está sendo criado
		subtema.setCodigo((Long) null);
		return subtemaRepository.save(subtema);
	}

	@Override
	public List<Subtema> findAll() {
		return subtemaRepository.findAll();
	}

}
