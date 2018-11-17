package com.tostringtech.refp.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.tostringtech.refp.core.entities.Projeto;
import com.tostringtech.refp.repositories.custom.ProjetoRepositoryCustom;

@Repository
public interface ProjetoRepository extends CrudRepository<Projeto, Long>, ProjetoRepositoryCustom {

	public Projeto findByCodAneel(String codAneel);
}
