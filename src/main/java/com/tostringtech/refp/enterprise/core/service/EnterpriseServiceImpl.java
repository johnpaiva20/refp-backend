package com.tostringtech.refp.enterprise.core.service;

import com.tostringtech.refp.application.models.Empresa;
import com.tostringtech.refp.enterprise.api.repository.EnterpriseRepository;
import com.tostringtech.refp.enterprise.api.service.EnterpriseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public  class EnterpriseServiceImpl implements EnterpriseService {

    @Autowired
    private EnterpriseRepository enterpriseRepository;

    @Override
    public List<Empresa> findAll() {
        return enterpriseRepository.findAll();
    }
    @Override
    public Optional<Empresa> findById(Long id){
        return enterpriseRepository.findById(id);
    }
    @Override
    public Empresa save(Empresa empresa) {
        return enterpriseRepository.save(empresa);
    }
    @Override
    public Empresa update(Empresa empresa) {
        return enterpriseRepository.saveAndFlush(empresa);
    }
    @Override
    public void delete(Empresa empresa) {
        enterpriseRepository.delete(empresa);
    }
}
