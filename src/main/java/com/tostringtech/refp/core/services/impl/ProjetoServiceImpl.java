package com.tostringtech.refp.core.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tostringtech.refp.core.entities.Despesa;
import com.tostringtech.refp.core.entities.Membro;
import com.tostringtech.refp.core.entities.Projeto;
import com.tostringtech.refp.repositories.ProjetoRepository;

@Service
public class ProjetoServiceImpl {

	@Autowired
	private ProjetoRepository projetoRepositorio;
	
	//Projeto 
	public Projeto create(Projeto projeto) {
		return projetoRepositorio.save(projeto);
	}

	public void delete(Projeto projeto) {
		projetoRepositorio.delete(projeto);
	}

	public void update(Projeto projeto) {
		projetoRepositorio.save(projeto);
	}

	public Projeto findByCodProjeto(Long codProjeto) {
		Optional<Projeto> p = projetoRepositorio.findById(codProjeto);
		return p.orElse(null);
	}

	public List<Projeto> findAll() {
		return (List<Projeto>) projetoRepositorio.findAll();
	}
	
}
