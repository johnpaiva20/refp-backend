package com.tostringtech.refp.core.repositories.dao.impl;

import com.tostringtech.refp.core.entities.Membro;
import com.tostringtech.refp.core.repositories.dao.MembroHibernateDAO;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

public class MembroHibernateDAOImpl implements MembroHibernateDAO {
    @PersistenceContext
    private EntityManager session;

    @Override
    public List<Membro> findByCodProjeto(Long codProjeto) {
        StringBuilder sql = new StringBuilder(" select m* from membro m,membro_projeto mp ");
        sql.append(" where mp.cod_membro=m.cod_membro ");
        sql.append(" and mp.cod_projeto=:codProjeto ");

        Query query = session.createNativeQuery(sql.toString(), Membro.class);
        query.setParameter("codProjeto", codProjeto);
        return query.getResultList();
    }
}
