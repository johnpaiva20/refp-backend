package com.tostringtech.refp.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.tostringtech.refp.core.entities.Membro;

public interface MembroRepository extends CrudRepository<Membro, Long> {
    @Query(value="select * from refp.membro m,refp.projeto_membros pm " + 
    		" where m.cod_membro=pm.cod_membro " + 
    		" and pm.cod_projeto=:codProjeto ", nativeQuery=true)
	public List<Membro> findByCodProjeto(@Param(value = "codProjeto") Long codProjeto);
}
