package com.tostringtech.refp.empresa.core.repository.impl;

import com.tostringtech.refp.application.model.EmpPro;
import com.tostringtech.refp.empresa.api.repository.EmpresaRepositoryCustom;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional
public class EmpresaRepositoryImpl implements EmpresaRepositoryCustom {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void addProjectEnterprises(List<EmpPro> enterprises, Long projectId) {
        for (EmpPro empresa : enterprises) {
            this.entityManager.persist(empresa);
        }
    }

    @Override
    public List<EmpPro> listAllProjectEnterprises(Long projectId) {
        return this.entityManager.createQuery("From EmpPro as emp where emp.projeto.codigo = :projectId ").setParameter("projectId",projectId).getResultList();
    }
}
