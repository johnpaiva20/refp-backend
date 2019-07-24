package com.tostringtech.refp.membro.api.repository;

import com.tostringtech.refp.application.models.Membro;
import org.springframework.data.repository.CrudRepository;

public interface MembroRepository extends CrudRepository<Membro, Long>, MembroRepositoryCustom {

}
