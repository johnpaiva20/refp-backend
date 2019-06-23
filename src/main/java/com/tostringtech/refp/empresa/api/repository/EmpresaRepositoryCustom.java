package com.tostringtech.refp.empresa.api.repository;

import com.tostringtech.refp.application.model.EmpPro;

import java.util.List;

public interface EmpresaRepositoryCustom {

    void addProjectEnterprises(List<EmpPro> enterprises, Long projectId);

    List<EmpPro> listAllProjectEnterprises(Long projectId);
}
