package com.tostringtech.refp.repositories;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.tostringtech.refp.core.entities.Projeto;

@Repository
public interface ProjetoRepository extends CrudRepository<Projeto, Long> {
	
	public Projeto findByCodAneel(String codAneel);
	
	@Modifying
	@Query( value=" INSERT INTO projeto_membros "
			+ " (membros_cod_membro, membro_cod_membro, sn_ativo, desc_titulacao, desc_funcao) "
			+ " value  (:membros_cod_membro, :membro_cod_membro, :sn_ativo, :desc_titulacao, :desc_funcao) ",nativeQuery=true )
	public void addProjectMember();
	

}
