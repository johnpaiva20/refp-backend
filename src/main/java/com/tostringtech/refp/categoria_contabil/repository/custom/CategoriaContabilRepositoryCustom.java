package com.tostringtech.refp.categoria_contabil.repository.custom;

import java.util.List;

public interface CategoriaContabilRepositoryCustom {

    List findAllByProjectType(String type);
}
