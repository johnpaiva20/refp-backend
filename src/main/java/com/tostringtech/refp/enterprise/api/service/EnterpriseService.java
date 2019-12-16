package com.tostringtech.refp.enterprise.api.service;

import com.tostringtech.refp.application.models.Empresa;

import java.util.List;
import java.util.Optional;

public interface EnterpriseService {
    List<Empresa> findAll();

    Optional<Empresa> findById(Long id);

    Empresa save(Empresa empresa);

    Empresa update(Empresa empresa);

    void delete(Empresa empresa);
}
