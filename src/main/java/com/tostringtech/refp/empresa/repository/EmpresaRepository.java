package com.tostringtech.refp.empresa.repository;

import com.tostringtech.refp.application.model.Empresa;
import com.tostringtech.refp.empresa.repository.custom.EmpresaRepositoryCustom;
import org.springframework.data.repository.CrudRepository;

public interface EmpresaRepository extends CrudRepository<Empresa, Long>, EmpresaRepositoryCustom {
}
