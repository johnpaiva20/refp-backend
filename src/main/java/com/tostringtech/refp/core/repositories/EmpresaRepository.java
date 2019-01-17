package com.tostringtech.refp.core.repositories;

import com.tostringtech.refp.core.entities.Empresa;
import com.tostringtech.refp.core.repositories.custom.EmpresaRepositoryCustom;
import org.springframework.data.repository.CrudRepository;

public interface EmpresaRepository extends CrudRepository<Empresa, Long>, EmpresaRepositoryCustom {
}
