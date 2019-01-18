package com.tostringtech.refp.core.services;

import com.tostringtech.refp.api.resources.EnterpriseResource;
import com.tostringtech.refp.api.resources.ProjectEnterpriseResource;
import com.tostringtech.refp.core.entities.Empresa;
import com.tostringtech.refp.core.entities.Projeto;
import com.tostringtech.refp.core.entities.relationships.EmpresaProjeto;

import java.util.List;

public interface EmpresaService {

    Empresa buildEmpresa(EnterpriseResource resource);

    EnterpriseResource buildEnterpriseResource(Empresa empresaProjeto);

    ProjectEnterpriseResource buildProjectEnterpriseResource(EmpresaProjeto empresaProjeto);

    EnterpriseResource create(EnterpriseResource enterpriseResource);

    Empresa create(Empresa empresa);

    boolean enterpriseExists(Long codEmpresa);

    List<ProjectEnterpriseResource> findByCodProjeto(Long codProjeto);

    Empresa findById(Long codEmpresa);

    Projeto addProjectEnterprise(Projeto projeto, EnterpriseResource entrpreise);
}
