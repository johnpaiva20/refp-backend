package com.tostringtech.refp.core.services;

import com.tostringtech.refp.api.resources.EnterpriseResource;
import com.tostringtech.refp.api.resources.MemberResource;
import com.tostringtech.refp.api.resources.ProjectEnterpriseResource;
import com.tostringtech.refp.api.resources.ProjectResource;
import com.tostringtech.refp.core.entities.*;

import java.io.File;
import java.util.List;


public interface ProjetoService {

    void addEnterprise(Long codProjeto, EnterpriseResource enterprise);

    void addProjectExpense(Despesa despesa, Long codProjeto);

    void addProjectMember(Long codMembro, Long codProjeto, Long codFuncao, Long codTitulacao);

    Recurso addRecursoProjeto(Recurso recurso);

    ProjectResource buildProjectResource(Projeto project);

    ProjectResource buildProjectResource(Long codProjeto);


    Projeto buildProjeto(File projectXML);

    Projeto buildProjeto(ProjectResource resource);

    ProjectResource create(Projeto projeto);

    ProjectResource create(ProjectResource projeto);

    void delete(Long codProjeto);

    void delete(Projeto projeto);

    List<ProjectResource> findAll();

    List<ProjectEnterpriseResource> findAllProjectEnterprises(Long codProjeto);

    List<FaseCadeiaInovacaoProjeto> findAllProjectInovationPhases();

    List<MemberResource> findAllProjectMembers(Long codProjeto);

    List<TipoProduto> findAllProjectProductsTypes();

    List<SegmentoProjeto> findAllProjectSegments();

    List<SubtemaProjeto> findAllProjectSubSubjects(String codTema);

    List<TemaProjeto> findAllProjectSubjects();

    List<TipoProjeto> findAllProjectTypes();

    Projeto findById(Long codProjeto);

    void removeProjectExpense(Despesa despesa, Long codProjeto);

    void removeProjectMember(Long codMembro, Long codProjeto);

    void update(Projeto projeto);

    void update(ProjectResource projeto);
}