package com.tostringtech.refp.categoria_contabil.api.repository;

import com.tostringtech.refp.application.models.CategoriaContabil;
import com.tostringtech.refp.categoria_contabil.api.rest.filters.AccountCategoryFilter;

import java.util.List;

public interface CategoriaContabilRepositoryCustom {

    List<CategoriaContabil> listAccountCategories(AccountCategoryFilter filter);
}
