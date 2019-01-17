package com.tostringtech.refp.core.repositories;

import com.tostringtech.refp.core.entities.Rubrica;
import com.tostringtech.refp.core.repositories.custom.RubricaRepositoryCustom;
import org.springframework.data.repository.CrudRepository;

public interface RubricaRepository extends CrudRepository<Rubrica, Long>, RubricaRepositoryCustom {


}
