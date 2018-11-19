package com.tostringtech.refp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tostringtech.refp.core.entities.SegmentoProjeto;
@Repository
public interface SegmentoProjetoRepository extends JpaRepository<SegmentoProjeto, String> {

}
