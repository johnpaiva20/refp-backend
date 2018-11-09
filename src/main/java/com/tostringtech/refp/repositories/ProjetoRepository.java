package com.tostringtech.refp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tostringtech.refp.core.entities.Projeto;

@Repository
public interface ProjetoRepository extends JpaRepository<Projeto, Long>{

}
