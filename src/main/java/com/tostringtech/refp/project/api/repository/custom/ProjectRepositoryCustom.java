package com.tostringtech.refp.project.api.repository.custom;

import com.tostringtech.refp.application.models.EmpPro;

import java.util.List;

public interface ProjectRepositoryCustom {

    void addEnterprises(List<EmpPro> empresas,Long id);
}
