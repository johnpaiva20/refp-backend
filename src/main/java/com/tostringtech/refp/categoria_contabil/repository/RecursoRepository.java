package com.tostringtech.refp.categoria_contabil.repository;

import com.tostringtech.refp.application.model.Recurso;
import com.tostringtech.refp.categoria_contabil.repository.custom.RecursoRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecursoRepository extends JpaRepository<Recurso, Long>, RecursoRepositoryCustom {


}
