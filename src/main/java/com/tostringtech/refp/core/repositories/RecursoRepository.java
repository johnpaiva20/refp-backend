package com.tostringtech.refp.core.repositories;

import com.tostringtech.refp.core.entities.Recurso;
import com.tostringtech.refp.core.repositories.custom.RecursoRepositoryCustom;
import org.springframework.data.repository.CrudRepository;

public interface RecursoRepository extends CrudRepository<Recurso, Long>, RecursoRepositoryCustom {


}
