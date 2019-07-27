package com.tostringtech.refp.application.authentication.core.repository;

import com.tostringtech.refp.application.authentication.core.models.User;
import com.tostringtech.refp.application.authentication.api.repository.UserRepositoryCustom;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

@Repository
@Transactional
public class UserRepositoryImpl implements UserRepositoryCustom {

    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public User findByUsernameOrEmail(String usernameOrEmail) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<User> query = cb.createQuery(User.class);
        Root<User> user = query.from(User.class);

        List<Predicate> predicates = new ArrayList<>();

        Predicate usernamePredicate = cb.equal(user.get("username"), usernameOrEmail);
        predicates.add(cb.and(usernamePredicate));

       // Predicate emailPredicate = cb.equal(user.get("username"), usernameOrEmail);
       // predicates.add(cb.or(emailPredicate));

        query.where(predicates.toArray(new Predicate[predicates.size()]));

        return entityManager.createQuery(query).getSingleResult();
    }
}
