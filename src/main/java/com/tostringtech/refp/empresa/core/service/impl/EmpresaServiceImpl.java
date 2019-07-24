package com.tostringtech.refp.empresa.core.service.impl;

import com.tostringtech.refp.application.models.EmpPro;
import com.tostringtech.refp.application.models.Empresa;
import com.tostringtech.refp.empresa.api.repository.EmpresaRepository;
import com.tostringtech.refp.empresa.api.services.EmpresaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmpresaServiceImpl implements EmpresaService {

    @Autowired
    private EmpresaRepository empresaRepository;


    @Override
    public List<Empresa> findAll() {
        return (List<Empresa>) empresaRepository.findAll();
    }

    @Override
    public Optional<Empresa> findById(Long codigo) {
        //Empresa empresa = empresaRepository.findById(codigo);
        return empresaRepository.findById(codigo);
    }

    @Override
    public Page<Empresa> findPage(Integer page, Integer linesPerPage, String orderBy, String direction) {
        return null;
    }

    @Override
    public Empresa create(Empresa empresa) {
        return empresaRepository.save(empresa);
    }

    @Override
    public Empresa update(Empresa empresa) {
        findById(empresa.getCodigo());
        return empresaRepository.save(empresa);
    }

    @Override
    public void delete(Long codigo) {
        findById(codigo);
        empresaRepository.deleteById(codigo);
    }

    @Override
    public void addProjectEnterprises(List<EmpPro> enterprises, Long projectId) {
        this.empresaRepository.addProjectEnterprises(enterprises, projectId);
    }

    @Override
    public List<EmpPro> listAllProjectEnterprises(Long projectId) {
        return this.empresaRepository.listAllProjectEnterprises(projectId);
    }

}
