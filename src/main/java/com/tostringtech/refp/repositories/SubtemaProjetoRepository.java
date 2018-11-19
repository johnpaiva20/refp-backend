package com.tostringtech.refp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tostringtech.refp.core.entities.SubtemaProjeto;
@Repository
public interface SubtemaProjetoRepository extends JpaRepository<SubtemaProjeto, String> {

}
