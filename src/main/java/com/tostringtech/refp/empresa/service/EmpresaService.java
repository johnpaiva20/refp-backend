package com.tostringtech.refp.empresa.service;

import com.tostringtech.refp.application.model.Empresa;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Optional;

public interface EmpresaService {

    Empresa create(Empresa empresa);

    void delete(Long codigo);

    Optional<Empresa> findById(Long codigo);

    List<Empresa> findAll();

    Page<Empresa> findPage(Integer page, Integer linesPerPage, String orderBy, String direction);

    Empresa update(Empresa empresa);
}
