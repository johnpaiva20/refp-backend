package com.tostringtech.refp.projeto.core.service;

import com.tostringtech.refp.application.models.Subtema;
import com.tostringtech.refp.projeto.api.repository.TemaRepository;
import com.tostringtech.refp.projeto.api.service.TemaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TemaServiceImpl implements TemaService {
	
	@Autowired
	TemaRepository temaRepository;
	
	@Override
	public Subtema create(Subtema subtema) {
		//garantindo que realmente algo 
		//novo está sendo criado
		subtema.setCodigo((Long) null);
		return temaRepository.save(subtema);
	}

	@Override
	public List<Subtema> findAll() {
		return temaRepository.findAll();
	}

}
