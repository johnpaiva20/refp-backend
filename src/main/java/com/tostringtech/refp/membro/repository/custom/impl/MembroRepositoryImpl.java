package com.tostringtech.refp.membro.repository.custom.impl;

import com.tostringtech.refp.application.model.Membro;
import com.tostringtech.refp.membro.repository.custom.MembroRepositoryCustom;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
@Transactional
public class MembroRepositoryImpl implements MembroRepositoryCustom {


    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Membro> findByCodProjeto(Long codProjeto) {
        StringBuilder sql = new StringBuilder(" select m* from membro m,membro_projeto mp ");
        sql.append(" where mp.cod_membro=m.cod_membro ");
        sql.append(" and mp.cod_projeto=:codProjeto ");

        Query query = this.entityManager.createNativeQuery(sql.toString(), Membro.class);
        query.setParameter("codProjeto", codProjeto);

        return query.getResultList();
    }

}
