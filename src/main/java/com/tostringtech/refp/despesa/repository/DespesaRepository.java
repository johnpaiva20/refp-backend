package com.tostringtech.refp.despesa.repository;

import com.tostringtech.refp.application.model.Despesa;
import org.springframework.data.repository.CrudRepository;

public interface DespesaRepository extends CrudRepository<Despesa, Long>, DespesaRepositoryCustom {


}
