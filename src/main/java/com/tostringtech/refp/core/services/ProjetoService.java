package com.tostringtech.refp.core.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tostringtech.refp.core.entities.Projeto;
import com.tostringtech.refp.repositories.ProjetoRepository;

@Service
public class ProjetoService {
	
	@Autowired
	private ProjetoRepository projetoRepositorio;
	
	public Projeto find(Long id) {
		Optional <Projeto> p = projetoRepositorio.findById(id);
		return p.orElse(null);
	}

}
