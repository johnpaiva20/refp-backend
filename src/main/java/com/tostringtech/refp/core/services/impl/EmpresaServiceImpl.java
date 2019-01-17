package com.tostringtech.refp.core.services.impl;

import com.tostringtech.refp.api.resources.EnterpriseResource;
import com.tostringtech.refp.api.resources.ProjectEnterpriseResource;
import com.tostringtech.refp.core.entities.Empresa;
import com.tostringtech.refp.core.entities.Projeto;
import com.tostringtech.refp.core.entities.relationships.EmpresaProjeto;
import com.tostringtech.refp.core.repositories.EmpresaRepository;
import com.tostringtech.refp.core.services.EmpresaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EmpresaServiceImpl implements EmpresaService {

    @Autowired
    private EmpresaRepository empresaRepository;

    public Empresa create(Empresa empresa) {
        empresa = empresaRepository.save(empresa);
        if (empresa != null) {
            return empresa;
        }
        return null;
    }

    public EnterpriseResource create(EnterpriseResource resource) {
        Empresa empresa = buildEmpresa(resource);
        empresa = empresaRepository.save(empresa);
        if (empresa != null) {
            return buildEnterpriseResource(empresa);
        }
        return null;
    }

    @Override
    public List<ProjectEnterpriseResource> findByCodProjeto(Long codProjeto) {
        return empresaRepository.findByCodProjeto(codProjeto).stream().map(enterprise -> new ProjectEnterpriseResource(enterprise.getEmpresa(), enterprise.getSnAtivo(), enterprise.getTipoEmpresa())).collect(Collectors.toList());
    }

    @Override
    public Empresa findById(Long codEmpresa) {
        Optional<Empresa> empresa = empresaRepository.findById(codEmpresa);
        return empresa.get();
    }

    @Override
    public Projeto addProjectEnterprise(Projeto projeto, EnterpriseResource entrpreise) {
        Empresa empresa = null;
        if (entrpreise.getId() != null && enterpriseExists(entrpreise.getId())) {
            empresa = buildEmpresa(entrpreise);
        } else {
            empresa = buildEmpresa(create(entrpreise));
        }
        EmpresaProjeto empresaProjeto = new EmpresaProjeto(empresa, projeto, "P");
        projeto.getEmpresas().add(empresaProjeto);
        return projeto;
    }

    @Override
    public ProjectEnterpriseResource buildProjectEnterpriseResource(EmpresaProjeto empresaProjeto) {
        ProjectEnterpriseResource resource = new ProjectEnterpriseResource();
        return resource;
        //TODO
    }

    @Override
    public EnterpriseResource buildEnterpriseResource(Empresa empresa) {
        EnterpriseResource resource = new EnterpriseResource();
        resource.setId(empresa.getCodEmpresa());
        resource.setCnpj(empresa.getNrCnpj());
        resource.setCompany(empresa.getDescRazaoSocial());
        resource.setTrade(empresa.getDescNomeFantasia());
        resource.setInitials(empresa.getDescSigla());
        return resource;
    }

    @Override
    public Empresa buildEmpresa(EnterpriseResource resource) {
        Empresa empresa = new Empresa();
        empresa.setCodEmpresa(resource.getId());
        empresa.setNrCnpj(resource.getCnpj());
        empresa.setDescRazaoSocial(resource.getCompany());
        empresa.setDescNomeFantasia(resource.getTrade());
        empresa.setDescSigla(resource.getInitials());
        return empresa;
    }

    @Override
    public boolean enterpriseExists(Long codEmpresa) {
        return empresaRepository.existsById(codEmpresa);
    }

}
