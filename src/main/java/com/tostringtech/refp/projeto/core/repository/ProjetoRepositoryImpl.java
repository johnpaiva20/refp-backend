package com.tostringtech.refp.projeto.core.repository;

import com.tostringtech.refp.application.model.*;
import com.tostringtech.refp.projeto.api.repository.ProjetoRepositoryCustom;
import com.tostringtech.refp.projeto.api.rest.filters.ProjectTypeFilter;
import org.hibernate.Criteria;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.*;
import java.util.List;

@Repository
@Transactional
public class ProjetoRepositoryImpl implements ProjetoRepositoryCustom {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Tema> findAllTopicsByProjectType(ProjectTypeFilter filter) {

        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Tema> query = cb.createQuery(Tema.class);
        Root<Tema> tema = query.from(Tema.class);

        query.select(tema);

        if (filter != null) {
            if (filter.getType() != null) {
                Predicate projectTypePredicate = cb.equal(tema.get("tipoProjeto").get("codigo"), filter.getType().getId());
                query.where(projectTypePredicate);
            }
        }
        return entityManager.createQuery(query).getResultList();
    }

    @Override
    public List<TipoProjeto> listAllProjectTypes() {

        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<TipoProjeto> query = cb.createQuery(TipoProjeto.class);
        Root<TipoProjeto> tipo = query.from(TipoProjeto.class);
        query.select(tipo);

        return entityManager.createQuery(query).getResultList();
    }

    @Override
    public List<Subtema> findAllSubtopicsByTopic(String tema) {
        StringBuilder sql = new StringBuilder();

        sql.append(" from Subtema where tema = :tema ");

        TypedQuery<Subtema> query = entityManager.createQuery(sql.toString(), Subtema.class);
        query.setParameter("tema", tema);

        return query.getResultList();
    }

    /*@Override
    public List<FaseInova> listAllInnovationPhases() {
        return this.entityManager.createQuery("From FaseInova", FaseInova.class).getResultList();
    }

    @Override
    public List<Produto> listAllProductsTypes() {
        return this.entityManager.createQuery("From Produto", Produto.class).getResultList();
    }

    @Override
    public List<Segmento> listAllSegments() {
        return this.entityManager.createQuery("From Segmento", Segmento.class).getResultList();
    }*/
}
