package com.tostringtech.refp.core.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.tostringtech.refp.core.entities.Membro;
import com.tostringtech.refp.core.entities.Projeto;
import com.tostringtech.refp.repositories.MembroRepository;

public class MembroService {
	@Autowired
	private MembroRepository membroRepositorio;

	// Membro
	public Membro create(Membro membro) {
		return membroRepositorio.save(membro);
	}

	public void delete(Membro membro) {
		membroRepositorio.delete(membro);
	}

	public void update(Membro membro) {
		membroRepositorio.save(membro);
	}

	public Membro find(Long codMembro) {
		Optional<Membro> membro = membroRepositorio.findById(codMembro);
		return membro.orElse(null);
	}

	public List<Membro> findAll() {
		return (List<Membro>) membroRepositorio.findAll();
	}

	public List<Membro> findByProject(Long codProjeto) {
		return (List<Membro>) membroRepositorio.findByCodProjeto(codProjeto);
	}
}
