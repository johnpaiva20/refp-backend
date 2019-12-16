package com.tostringtech.refp.project.core.repository;

import com.tostringtech.refp.application.models.Subtema;
import com.tostringtech.refp.application.models.TipoProduto;
import com.tostringtech.refp.application.models.TipoProjeto;
import com.tostringtech.refp.project.api.repository.custom.ProjectRepositoryCustom;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
@Transactional
public class ProjectRepositoryImpl implements ProjectRepositoryCustom {

    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public List<TipoProjeto> listAllProjectTypes() {

        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<TipoProjeto> query = cb.createQuery(TipoProjeto.class);
        Root<TipoProjeto> tipo = query.from(TipoProjeto.class);
        query.select(tipo);

        return entityManager.createQuery(query).getResultList();
    }

    @Override
    public List<Subtema> findAllSubtopicsByTopic(Long tema) {
        StringBuilder sql = new StringBuilder();
        if (tema != null) {
                sql.append(" from Subtema where tema.codigo = :tema ");

        } else {
            sql.append(" from Subtema ");
        }

        TypedQuery<Subtema> query = entityManager.createQuery(sql.toString(), Subtema.class);

        if (tema != null) {
            query.setParameter("tema", tema);
        }

        return query.getResultList();
    }

    @Override
    public List<TipoProduto> listProductsTypes() {

        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<TipoProduto> query = cb.createQuery(TipoProduto.class);
        Root<TipoProduto> tipo = query.from(TipoProduto.class);
        query.select(tipo);

        return entityManager.createQuery(query).getResultList();
    }


}
