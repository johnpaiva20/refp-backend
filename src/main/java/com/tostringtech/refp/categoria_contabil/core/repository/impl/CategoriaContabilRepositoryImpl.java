package com.tostringtech.refp.categoria_contabil.core.repository.impl;

import com.tostringtech.refp.application.model.CategoriaContabil;
import com.tostringtech.refp.categoria_contabil.api.repository.CategoriaContabilRepositoryCustom;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
@Transactional
public class CategoriaContabilRepositoryImpl implements CategoriaContabilRepositoryCustom {

    @PersistenceContext
    EntityManager entityManager;


    @Override
    public List<CategoriaContabil> findAllByProjectType(String type) {

        StringBuilder hql = new StringBuilder();

        hql.append(" from CategoriaContabil cc where cc.tipoProjeto = :type ");

        TypedQuery query = entityManager.createQuery(hql.toString(), CategoriaContabil.class);

        query.setParameter("type", type);

        return query.getResultList();
    }
}
