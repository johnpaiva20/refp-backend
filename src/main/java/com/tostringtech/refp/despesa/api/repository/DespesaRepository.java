package com.tostringtech.refp.despesa.api.repository;

import com.tostringtech.refp.application.model.Despesa;
import org.springframework.data.repository.CrudRepository;

public interface DespesaRepository extends CrudRepository<Despesa, Long>, DespesaRepositoryCustom {


}
