package com.tostringtech.refp.categoria_contabil.core.service.impl;

import com.tostringtech.refp.application.model.CategoriaContabil;
import com.tostringtech.refp.categoria_contabil.api.repository.CategoriaContabilRepository;
import com.tostringtech.refp.categoria_contabil.api.rest.filters.AccountCategoryFilter;
import com.tostringtech.refp.categoria_contabil.api.service.CategoriaContabilService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriaContabilServiceImpl implements CategoriaContabilService {

    @Autowired
    private CategoriaContabilRepository categoriaContabilRepository;

    @Override
    public List<CategoriaContabil> listAccountCategories(AccountCategoryFilter filter) {
        return categoriaContabilRepository.listAccountCategories(filter);
    }
}
