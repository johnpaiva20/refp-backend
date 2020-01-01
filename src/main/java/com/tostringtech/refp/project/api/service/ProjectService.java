package com.tostringtech.refp.project.api.service;

import com.tostringtech.refp.application.models.EmpPro;
import com.tostringtech.refp.application.models.Projeto;
import org.springframework.data.domain.Pageable;


import java.util.List;
import java.util.Optional;

public interface ProjectService {

    Projeto create(Projeto projeto);

    Projeto update(Projeto projeto);

    Projeto delete(Projeto projeto);

    List<EmpPro> findAllProjectEnterprises(Long id);

    List<Projeto> findAll(Pageable pageable);

    Optional<Projeto> findById(Long id);

    List<Projeto> findAll();

    void addEnterprises(List<EmpPro> empresas, Long id);
}
