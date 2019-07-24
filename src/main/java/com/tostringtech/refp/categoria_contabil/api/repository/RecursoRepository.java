package com.tostringtech.refp.categoria_contabil.api.repository;

import com.tostringtech.refp.application.models.Recurso;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecursoRepository extends JpaRepository<Recurso, Long>, RecursoRepositoryCustom {


}
