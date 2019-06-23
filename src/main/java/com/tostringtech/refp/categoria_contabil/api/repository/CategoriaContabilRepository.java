package com.tostringtech.refp.categoria_contabil.api.repository;

import com.tostringtech.refp.application.model.CategoriaContabil;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaContabilRepository extends JpaRepository<CategoriaContabil, Long>, CategoriaContabilRepositoryCustom {


}
