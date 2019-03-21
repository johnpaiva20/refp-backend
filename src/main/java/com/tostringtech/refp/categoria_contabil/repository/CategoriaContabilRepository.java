package com.tostringtech.refp.categoria_contabil.repository;

import com.tostringtech.refp.application.model.CategoriaContabil;
import com.tostringtech.refp.categoria_contabil.repository.custom.CategoriaContabilRepositoryCustom;
import org.springframework.data.repository.CrudRepository;

public interface CategoriaContabilRepository extends CrudRepository<CategoriaContabil, Long>, CategoriaContabilRepositoryCustom {


}
