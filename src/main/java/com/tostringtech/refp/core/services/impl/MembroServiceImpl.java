package com.tostringtech.refp.core.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tostringtech.refp.core.entities.Membro;
import com.tostringtech.refp.core.repositories.MembroRepository;
import com.tostringtech.refp.core.services.MembroService;

@Service
public class MembroServiceImpl implements MembroService {

	@Autowired
	private MembroRepository membroRepositorio;

	public Membro create(Membro membro) {
		return membroRepositorio.save(membro);
	}

	public void delete(Membro membro) {
		membroRepositorio.delete(membro);
	}

	public Membro update(Membro membro) {
		return membroRepositorio.save(membro);
	}

	public List<Membro> findAll() {
		return (List<Membro>) membroRepositorio.findAll();
	}

	public List<Membro> findByProject(Long codProjeto) {
		return (List<Membro>) membroRepositorio.findByCodProjeto(codProjeto);
	}

	public void delete(Long codMembro) {
		// TODO Auto-generated method stub

	}

	@Override
	public Membro findByCod(Long codObj) {
		Optional<Membro> m=membroRepositorio.findById(codObj);
		return m.orElse(null);
	}

}
