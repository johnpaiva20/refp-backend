package com.tostringtech.refp.despesa.api.repository;

import com.tostringtech.refp.application.models.Despesa;
import org.springframework.data.repository.CrudRepository;

public interface DespesaRepository extends CrudRepository<Despesa, Long>, DespesaRepositoryCustom {


}
