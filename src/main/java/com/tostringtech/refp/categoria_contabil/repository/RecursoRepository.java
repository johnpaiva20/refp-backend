package com.tostringtech.refp.categoria_contabil.repository;

import com.tostringtech.refp.application.model.Recurso;
import com.tostringtech.refp.categoria_contabil.repository.custom.RecursoRepositoryCustom;
import org.springframework.data.repository.CrudRepository;

public interface RecursoRepository extends CrudRepository<Recurso, Long>, RecursoRepositoryCustom {


}
