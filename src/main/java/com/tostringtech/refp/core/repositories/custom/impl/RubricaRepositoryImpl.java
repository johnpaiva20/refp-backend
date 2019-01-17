package com.tostringtech.refp.core.repositories.custom.impl;

import com.tostringtech.refp.core.repositories.custom.RecursoRepositoryCustom;
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
