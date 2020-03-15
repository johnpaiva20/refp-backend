package com.tostringtech.refp.project.api.service;

import com.tostringtech.refp.application.models.EmpPro;
import com.tostringtech.refp.application.models.Projeto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


import java.util.List;
import java.util.Optional;

public interface ProjectService {

    Projeto create(Projeto projeto);

    Projeto update(Projeto projeto);

    void delete(Projeto projeto);

    List<EmpPro> findAllProjectEnterprises(Long id);

    abstract Page<Projeto> findAll(Pageable pageable);

    Optional<Projeto> findById(Long id);

    abstract Page<Projeto> findAll();

    List<Projeto> findAllProjects();

    Page<Projeto> findAllPages(Pageable pageable);

    Long countProjects();

    void addEnterprises(List<EmpPro> empresas, Long id);
}
