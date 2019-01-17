package com.tostringtech.refp.core.repositories;

import com.tostringtech.refp.core.entities.Despesa;
import com.tostringtech.refp.core.repositories.custom.DespesaRepositoryCustom;
import org.springframework.data.repository.CrudRepository;

public interface DespesaRepository extends CrudRepository<Despesa, Long>, DespesaRepositoryCustom {


}
