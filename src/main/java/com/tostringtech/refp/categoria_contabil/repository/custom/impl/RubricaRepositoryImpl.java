package com.tostringtech.refp.categoria_contabil.repository.custom.impl;

import com.tostringtech.refp.categoria_contabil.repository.custom.RecursoRepositoryCustom;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
@Transactional
public class RubricaRepositoryImpl implements RecursoRepositoryCustom {

    @PersistenceContext
    EntityManager entityManager;


}
