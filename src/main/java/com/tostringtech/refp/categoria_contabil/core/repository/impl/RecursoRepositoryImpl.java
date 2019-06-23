package com.tostringtech.refp.categoria_contabil.core.repository.impl;

import com.tostringtech.refp.categoria_contabil.api.repository.RecursoRepositoryCustom;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
@Transactional
public class RecursoRepositoryImpl implements RecursoRepositoryCustom {


    @PersistenceContext
    EntityManager entityManager;


}
