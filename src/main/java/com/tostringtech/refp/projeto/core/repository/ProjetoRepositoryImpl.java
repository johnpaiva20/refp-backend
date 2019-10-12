package com.tostringtech.refp.projeto.core.repository;

import com.tostringtech.refp.application.models.Subtema;
import com.tostringtech.refp.application.models.Tema;
import com.tostringtech.refp.application.models.TipoProduto;
import com.tostringtech.refp.application.models.TipoProjeto;
import com.tostringtech.refp.projeto.api.repository.custom.ProjetoRepositoryCustom;
import com.tostringtech.refp.projeto.api.rest.filters.TopicFilter;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

@Repository
@Transactional
public class ProjetoRepositoryImpl implements ProjetoRepositoryCustom {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Tema> findAllTopicsByProjectType(TopicFilter filter) {

        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Tema> query = cb.createQuery(Tema.class);
        Root<Tema> tema = query.from(Tema.class);

        query.select(tema);

        List<Predicate> predicates = new ArrayList<>();
        if (filter != null) {

            if (filter.getType() != null) {
                Predicate projectTypePredicate = cb.equal(tema.get("tipoProjeto").get("codigo"), filter.getType().getId());
                predicates.add(cb.and(projectTypePredicate));
            }
            if (filter.getPriority() != null) {
                Predicate priorityPredicate = cb.equal(tema.get("prioritario"), filter.getPriority().getId());
                predicates.add(cb.and(priorityPredicate));
            }
            query.where(predicates.toArray(new Predicate[predicates.size()]));
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

    /*@Override
    public List<FaseInova> listAllInnovationPhases() {
        return this.entityManager.createQuery("From FaseInova", FaseInova.class).getResultList();
    }


    @Override
    public List<Segmento> listAllSegments() {
        return this.entityManager.createQuery("From Segmento", Segmento.class).getResultList();
    }*/
}
