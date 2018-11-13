package com.tostringtech.refp.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.tostringtech.refp.core.entities.Projeto;

@Repository
public interface ProjetoRepository extends CrudRepository<Projeto, Long> {
	public Projeto findByCdAneel(String cdAneel);
	//public List<Projeto> findByStatus(String status);
	//public List<Projeto> findByDsTituloLike(String dsTitulo);
	

}
