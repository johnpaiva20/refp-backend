package com.tostringtech.refp.core.repositories;

import com.tostringtech.refp.core.entities.Membro;
import com.tostringtech.refp.core.repositories.custom.MembroRepositoryCustom;
import org.springframework.data.repository.CrudRepository;

public interface MembroRepository extends CrudRepository<Membro, Long>, MembroRepositoryCustom {

}
