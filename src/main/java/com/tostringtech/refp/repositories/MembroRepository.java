package com.tostringtech.refp.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.tostringtech.refp.core.entities.Membro;

public interface MembroRepository extends CrudRepository<Membro, Long> {
     //public List<Membro> findByProjetosCodProjeto(Long codProjeto);
}
