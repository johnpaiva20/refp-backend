package com.tostringtech.refp.projeto.core.repository.impl;

import com.tostringtech.refp.application.model.*;
import com.tostringtech.refp.projeto.api.repository.ProjetoRepositoryCustom;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
@Transactional
public class ProjetoRepositoryImpl implements ProjetoRepositoryCustom {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Tema> findAllTopicsByProjectType(String type) {
        StringBuilder sql = new StringBuilder();

        sql.append(" from Tema where tipoProjeto = :type ");

        TypedQuery<Tema> query = entityManager.createQuery(sql.toString(), Tema.class);
        query.setParameter("type", type);

        return query.getResultList();
    }

    @Override
    public List<TipProj> listAllProjectTypes() {
        return this.entityManager.createQuery("From TipPro",TipProj.class).getResultList();
    }

    @Override
    public List<FaseInova> listAllInnovationPhases() {
        return this.entityManager.createQuery("From FaseInova",FaseInova.class).getResultList();
    }

    @Override
    public List<Produto> listAllProductsTypes() {
        return this.entityManager.createQuery("From Produto",Produto.class).getResultList();
    }

    @Override
    public List<Segmento> listAllSegments() {
        return this.entityManager.createQuery("From Segmento",Segmento.class).getResultList();
    }

    @Override
    public List<Subtema> findAllSubtopicsByTopic(String tema) {
        StringBuilder sql = new StringBuilder();

        sql.append(" from Subtema where tema = :tema ");

        TypedQuery<Subtema> query = entityManager.createQuery(sql.toString(), Subtema.class);
        query.setParameter("tema", tema);

        return query.getResultList();
    }
}
