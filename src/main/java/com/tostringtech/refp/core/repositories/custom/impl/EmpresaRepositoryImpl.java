package com.tostringtech.refp.core.repositories.custom.impl;

import com.tostringtech.refp.core.entities.relationships.EmpresaProjeto;
import com.tostringtech.refp.core.repositories.custom.EmpresaRepositoryCustom;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
@Transactional
public class EmpresaRepositoryImpl implements EmpresaRepositoryCustom {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<EmpresaProjeto> findByCodProjeto(Long codProjeto) {
        StringBuilder hql = new StringBuilder("from EmpresaProjeto as ep ");
        hql.append("where ep.projeto.codProjeto=:codProjeto");
        Query query = this.entityManager.createQuery(hql.toString(), EmpresaProjeto.class);
        query.setParameter("codProjeto", codProjeto);
        return query.getResultList();

    }

}
