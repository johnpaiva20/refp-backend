package com.tostringtech.refp.core.repositories.custom.impl;

import com.tostringtech.refp.core.entities.*;
import com.tostringtech.refp.core.repositories.custom.ProjetoRepositoryCustom;
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
    public List<SegmentoProjeto> findAllProjectSegments() {
        StringBuilder hql = new StringBuilder("from SegmentoProjeto");
        TypedQuery<SegmentoProjeto> query = this.entityManager.createQuery(hql.toString(), SegmentoProjeto.class);
        return query.getResultList();
    }

    @Override
    public void addProjectMember(Long codMembro, Long codProjeto, Long codFuncao, Long codTitulacao) {

    }

    @Override
    public void removeProjectMember(Long codMembro, Long codProjeto) {

    }

    @Override
    public void inativateProjectMember(Long codMembro, Long codProjeto) {

    }

    @Override
    public void addProjectExpense(Long codDespesa, Long codProjeto) {

    }

    @Override
    public void removeProjectExpense(Long codDespesa, Long codProjeto) {

    }

    @Override
    public List<TipoProjeto> findAllProjectTypes() {
        StringBuilder hql = new StringBuilder("from TipoProjeto");
        TypedQuery<TipoProjeto> query = this.entityManager.createQuery(hql.toString(), TipoProjeto.class);
        return query.getResultList();
    }

    @Override
    public List<TipoProduto> findAllProjectProductsTypes() {
        StringBuilder hql = new StringBuilder("from TipoProduto");
        TypedQuery<TipoProduto> query = this.entityManager.createQuery(hql.toString(), TipoProduto.class);
        return query.getResultList();
    }

    @Override
    public List<TemaProjeto> findAllProjectSubjects(String codTipoProjeto) {
        StringBuilder hql = new StringBuilder("from TemaProjeto as tema where tema.tipoProjeto.codTipoProjeto =:codTipoProjeto ");
        TypedQuery<TemaProjeto> query = entityManager.createQuery(hql.toString(), TemaProjeto.class);
        query.setParameter("codTipoProjeto", codTipoProjeto);
        return query.getResultList();
    }

    @Override
    public List<FaseCadeiaInovacaoProjeto> findAllProjectInovationPhases() {
        StringBuilder hql = new StringBuilder("from FaseCadeiaInovacaoProjeto");
        TypedQuery<FaseCadeiaInovacaoProjeto> query = this.entityManager.createQuery(hql.toString(), FaseCadeiaInovacaoProjeto.class);
        return query.getResultList();
    }

    @Override
    public List<SubtemaProjeto> findAllProjectSubSubjects(String codTema) {
        StringBuilder hql = new StringBuilder("from SubtemaProjeto as sub where sub.tema.codTema =:codTema ");
        TypedQuery<SubtemaProjeto> query = this.entityManager.createQuery(hql.toString(), SubtemaProjeto.class);
        query.setParameter("codTema", codTema);
        return query.getResultList();
    }


}
