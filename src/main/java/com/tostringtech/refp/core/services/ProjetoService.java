package com.tostringtech.refp.core.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tostringtech.refp.core.entities.Membro;
import com.tostringtech.refp.core.entities.Projeto;
import com.tostringtech.refp.repositories.MembroRepository;
import com.tostringtech.refp.repositories.ProjetoRepository;

@Service
public class ProjetoService {

	@Autowired
	private ProjetoRepository projetoRepositorio;

	@Autowired
	private MembroRepository membroRepositorio;

	public Projeto create(Projeto projeto) {
		return projetoRepositorio.save(projeto);
	}

	public Projeto find(Long codProjeto) {
		Optional<Projeto> p = projetoRepositorio.findById(codProjeto);
		return p.orElse(null);
	}

	public List<Projeto> findAll() {
		return (List<Projeto>) projetoRepositorio.findAll();
	}

	/*public List<Membro> findAllProjectMembers(Long codProjeto) {
		return membroRepositorio.findByProjetosCodProjeto(codProjeto);

	}*/

}
