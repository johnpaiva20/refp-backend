package com.tostringtech.refp.projeto.repository.custom.impl;

import com.tostringtech.refp.projeto.repository.custom.ProjetoRepositoryCustom;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
@Transactional
public class ProjetoRepositoryImpl implements ProjetoRepositoryCustom {

    @PersistenceContext
    private EntityManager entityManager;


}
