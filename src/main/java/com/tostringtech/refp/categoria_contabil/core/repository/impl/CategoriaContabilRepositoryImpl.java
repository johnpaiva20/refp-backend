package com.tostringtech.refp.categoria_contabil.core.repository.impl;

import com.tostringtech.refp.application.model.CategoriaContabil;
import com.tostringtech.refp.application.model.Tema;
import com.tostringtech.refp.categoria_contabil.api.repository.CategoriaContabilRepositoryCustom;
import com.tostringtech.refp.categoria_contabil.api.rest.filters.AccountCategoryFilter;
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
public class CategoriaContabilRepositoryImpl implements CategoriaContabilRepositoryCustom {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public List<CategoriaContabil> listAccountCategories(AccountCategoryFilter filter) {

        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<CategoriaContabil> query = cb.createQuery(CategoriaContabil.class);
        Root<CategoriaContabil> categoria = query.from(CategoriaContabil.class);

        query.select(categoria);

        List<Predicate> predicates = new ArrayList<>();
        if (filter != null) {

            if (filter.getType() != null) {
                Predicate projectTypePredicate = cb.equal(categoria.get("tipoProjeto").get("codigo"), filter.getType().getId());
                predicates.add(cb.and(projectTypePredicate));
            }

            query.where(predicates.toArray(new Predicate[predicates.size()]));
        }
        return entityManager.createQuery(query).getResultList();
    }
}
