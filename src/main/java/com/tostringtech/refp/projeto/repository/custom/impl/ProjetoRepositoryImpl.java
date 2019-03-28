package com.tostringtech.refp.projeto.repository.custom.impl;

import com.tostringtech.refp.application.model.Subtema;
import com.tostringtech.refp.application.model.Tema;
import com.tostringtech.refp.projeto.repository.custom.ProjetoRepositoryCustom;
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

        TypedQuery query = entityManager.createQuery(sql.toString(), Tema.class);
        query.setParameter("type", type);

        return query.getResultList();
    }

    @Override
    public List<Subtema> findAllSubtopicsByTopic(String tema) {
        StringBuilder sql = new StringBuilder();

        sql.append(" from Subtema where tema = :tema ");

        TypedQuery query = entityManager.createQuery(sql.toString(), Subtema.class);
        query.setParameter("tema", tema);

        return query.getResultList();
    }
}
