package com.tostringtech.refp.despesa.core.repository.impl;

import com.tostringtech.refp.categoria_contabil.api.repository.RecursoRepositoryCustom;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
@Transactional
public class DespesaRepositoryImpl implements RecursoRepositoryCustom {

    @PersistenceContext
    EntityManager entityManager;

}
