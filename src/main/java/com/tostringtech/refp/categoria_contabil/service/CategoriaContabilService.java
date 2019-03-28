package com.tostringtech.refp.categoria_contabil.service;

import com.tostringtech.refp.application.model.CategoriaContabil;
import com.tostringtech.refp.categoria_contabil.repository.CategoriaContabilRepository;

import java.util.List;

public interface CategoriaContabilService {


    List<CategoriaContabil> findAllByProjectType(String type);

    List<CategoriaContabil> findAll();
}
