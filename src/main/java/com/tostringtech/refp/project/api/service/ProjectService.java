package com.tostringtech.refp.project.api.service;

import com.tostringtech.refp.application.exceptions.StandardException;
import com.tostringtech.refp.application.models.EmpPro;
import com.tostringtech.refp.application.models.Projeto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


import java.util.List;
import java.util.Optional;

public interface ProjectService {

    Projeto create(Projeto projeto) throws StandardException;

    Projeto update(Projeto projeto);

    void delete(Projeto projeto);

    List<EmpPro> findAllProjectEnterprises(Long id);

     List<Projeto> findAll(Pageable pageable);

    int getTotalProjectPages(Pageable pageable);

    Optional<Projeto> findById(Long id);

    Long countProjects();

    void addEnterprises(List<EmpPro> empresas, Long id);
}
