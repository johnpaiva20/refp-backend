package com.tostringtech.refp.despesa.repository;

import com.tostringtech.refp.categoria_contabil.repository.custom.RecursoRepositoryCustom;
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
