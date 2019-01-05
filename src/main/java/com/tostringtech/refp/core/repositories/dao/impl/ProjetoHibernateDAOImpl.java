package com.tostringtech.refp.core.repositories.dao.impl;

import java.util.List;

import javax.management.QueryEval;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.tostringtech.refp.core.entities.FaseCadeiaInovacaoProjeto;
import com.tostringtech.refp.core.entities.SegmentoProjeto;
import com.tostringtech.refp.core.entities.SubtemaProjeto;
import com.tostringtech.refp.core.entities.TemaProjeto;
import com.tostringtech.refp.core.entities.TipoProduto;
import com.tostringtech.refp.core.entities.TipoProjeto;
import com.tostringtech.refp.core.repositories.dao.ProjetoHibernateDAO;

@Repository
public class ProjetoHibernateDAOImpl implements ProjetoHibernateDAO {
    @PersistenceContext
    private EntityManager session;
	
	
	/*public ProjetoHibernateDAOImpl( SessionFactory factory) {
		super.setSessionFactory(factory);
	}*/

    @Override
    public List<SegmentoProjeto> findAllProjectSegments() {
        StringBuilder hql = new StringBuilder("from SegmentoProjeto");
        TypedQuery<SegmentoProjeto> query = session.createQuery(hql.toString(), SegmentoProjeto.class);
        return query.getResultList();
    }

    @Override
    public void addProjectMember(Long codMembro, Long codProjeto, Long codFuncao, Long codTitulacao) {
        StringBuilder sql = new StringBuilder(" INSERT INTO membro_projeto(cod_membro,cod_projeto,cod_funcao_membro,cod_titulacao_membro)");
        sql.append(" VALUES(?,?,?,?,?)");
        Query query = session.createNativeQuery(sql.toString());
        query.setParameter(1, codMembro);
        query.setParameter(2, codProjeto);
        query.setParameter(3, codFuncao);
        query.setParameter(4, codTitulacao);
        int resultCod = query.executeUpdate();
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
        TypedQuery<TipoProjeto> query = this.session.createQuery(hql.toString(), TipoProjeto.class);
        return query.getResultList();
    }

    @Override
    public List<TipoProduto> findAllProjectProductsTypes() {
        StringBuilder hql = new StringBuilder("from TipoProduto");
        TypedQuery<TipoProduto> query = session.createQuery(hql.toString(), TipoProduto.class);
        return query.getResultList();
    }

    @Override
    public List<TemaProjeto> findAllProjectSubjects() {
        StringBuilder hql = new StringBuilder("from TemaProjeto");
        TypedQuery<TemaProjeto> query = session.createQuery(hql.toString(), TemaProjeto.class);
        return query.getResultList();
    }

    @Override
    public List<FaseCadeiaInovacaoProjeto> findAllProjectInovationPhases() {
        StringBuilder hql = new StringBuilder("from FaseCadeiaInovacaoProjeto");
        TypedQuery<FaseCadeiaInovacaoProjeto> query = session.createQuery(hql.toString(), FaseCadeiaInovacaoProjeto.class);
        return query.getResultList();
    }

    @Override
    public List<SubtemaProjeto> findAllProjectSubSubjects(String codTema) {
        StringBuilder hql = new StringBuilder("from SubtemaProjeto as sub where sub.tema.codTema =:codTema ");
        TypedQuery<SubtemaProjeto> query = session.createQuery(hql.toString(), SubtemaProjeto.class);
        query.setParameter("codTema",codTema);
        return query.getResultList();
    }

}
