package com.tostringtech.refp.repositories;

import org.springframework.data.repository.CrudRepository;

import com.tostringtech.refp.core.entities.Empresa;

public interface EmpresaRepository  extends CrudRepository<Empresa, Long> {

}
