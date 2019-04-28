package com.tostringtech.refp.empresa.service;

import com.tostringtech.refp.application.model.Empresa;

import java.util.List;

public interface EmpresaService {
    Empresa create(Empresa empresa);

    List<Empresa> findAll();
}
