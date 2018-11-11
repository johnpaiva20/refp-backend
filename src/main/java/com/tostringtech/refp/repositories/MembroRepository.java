package com.tostringtech.refp.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.tostringtech.refp.core.entities.Membro;

public interface MembroRepository extends CrudRepository<Membro, Long> {
    @Query(value=" select * from membro m,projeto_membros pm " + 
    		" where pm.membros_cod_membro=m.cod_membro " + 
    		" and pm.projeto_cod_projeto=:codProjeto", nativeQuery=true)
	public List<Membro> findByCodProjeto(@Param(value = "codProjeto") Long codProjeto);
}
