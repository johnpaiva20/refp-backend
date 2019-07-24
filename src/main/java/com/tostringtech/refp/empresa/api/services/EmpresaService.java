package com.tostringtech.refp.empresa.api.services;

import com.tostringtech.refp.application.models.EmpPro;
import com.tostringtech.refp.application.models.Empresa;
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

    void addProjectEnterprises(List<EmpPro> enterprises, Long projectId);

    List<EmpPro> listAllProjectEnterprises(Long projectId);
}
