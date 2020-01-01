package com.tostringtech.refp.project.core.repository;

import com.tostringtech.refp.application.models.EmpPro;
import com.tostringtech.refp.application.models.Projeto;
import com.tostringtech.refp.project.api.repository.custom.ProjectRepositoryCustom;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional
public class ProjectRepositoryImpl implements ProjectRepositoryCustom {

    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public void addEnterprises(List<EmpPro> empresas, Long id) {
        Projeto projeto = new Projeto(id);
        projeto.getEmpresas().addAll(empresas);
        entityManager.persist(projeto);
    }
}
