package com.tostringtech.refp.categoria_contabil.repository;

import com.tostringtech.refp.application.model.CategoriaContabil;
import com.tostringtech.refp.categoria_contabil.repository.custom.CategoriaContabilRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaContabilRepository extends JpaRepository<CategoriaContabil, Long>, CategoriaContabilRepositoryCustom {


}
