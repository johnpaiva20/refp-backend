package com.tostringtech.refp.empresa.repository.custom.impl;

import com.tostringtech.refp.empresa.repository.custom.EmpresaRepositoryCustom;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
@Transactional
public class EmpresaRepositoryImpl implements EmpresaRepositoryCustom {

    @PersistenceContext
    private EntityManager entityManager;

}
