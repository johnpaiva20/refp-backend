package com.tostringtech.refp.categoria_contabil.api.service;

import com.tostringtech.refp.application.model.CategoriaContabil;

import java.util.List;

public interface CategoriaContabilService {


    List<CategoriaContabil> findAllByProjectType(String type);

    List<CategoriaContabil> findAll();
}
