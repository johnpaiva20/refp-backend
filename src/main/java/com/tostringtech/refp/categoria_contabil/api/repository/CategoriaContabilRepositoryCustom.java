package com.tostringtech.refp.categoria_contabil.api.repository;

import java.util.List;

public interface CategoriaContabilRepositoryCustom {

    List findAllByProjectType(String type);
}
