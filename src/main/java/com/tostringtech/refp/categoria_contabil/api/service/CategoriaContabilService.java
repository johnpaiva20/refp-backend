package com.tostringtech.refp.categoria_contabil.api.service;

import com.tostringtech.refp.application.models.CategoriaContabil;
import com.tostringtech.refp.categoria_contabil.api.rest.filters.AccountCategoryFilter;

import java.util.BitSet;
import java.util.List;

public interface CategoriaContabilService {

    List<CategoriaContabil> listAccountCategories(AccountCategoryFilter filter);
}
