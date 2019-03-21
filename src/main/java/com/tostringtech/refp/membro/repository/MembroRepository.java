package com.tostringtech.refp.membro.repository;

import com.tostringtech.refp.application.model.Membro;
import com.tostringtech.refp.membro.repository.custom.MembroRepositoryCustom;
import org.springframework.data.repository.CrudRepository;

public interface MembroRepository extends CrudRepository<Membro, Long>, MembroRepositoryCustom {

}
