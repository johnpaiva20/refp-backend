package com.tostringtech.refp.empresa.repository;

import com.tostringtech.refp.application.model.Empresa;
import com.tostringtech.refp.empresa.repository.custom.EmpresaRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmpresaRepository extends JpaRepository<Empresa, Long>, EmpresaRepositoryCustom {
}
