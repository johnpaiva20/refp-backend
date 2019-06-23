package com.tostringtech.refp.empresa.api.repository;

import com.tostringtech.refp.application.model.Empresa;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EmpresaRepository extends JpaRepository<Empresa, Long>, EmpresaRepositoryCustom {
    Optional<Empresa> findById(Long codigo);
}
