package com.tostringtech.refp.categoria_contabil.service.impl;

import com.tostringtech.refp.application.model.CategoriaContabil;
import com.tostringtech.refp.categoria_contabil.repository.CategoriaContabilRepository;
import com.tostringtech.refp.categoria_contabil.service.CategoriaContabilService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriaContabilServiceImpl implements CategoriaContabilService {

    @Autowired
    private CategoriaContabilRepository categoriaContabilRepository;

    @Override
    public List<CategoriaContabil> findAllByProjectType(String type) {
        return categoriaContabilRepository.findAllByProjectType(type);
    }

    @Override
    public List<CategoriaContabil> findAll() {
        return categoriaContabilRepository.findAll();
    }


}
