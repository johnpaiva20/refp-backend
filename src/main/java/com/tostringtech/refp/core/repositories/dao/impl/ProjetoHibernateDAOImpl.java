package com.tostringtech.refp.core.repositories.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
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
public class ProjetoHibernateDAOImpl  implements ProjetoHibernateDAO {
	@PersistenceContext
	private EntityManager session;
	
	
	/*public ProjetoHibernateDAOImpl( SessionFactory factory) {
		super.setSessionFactory(factory);
	}*/

	@Override
	public List<SegmentoProjeto> findAllProjectSegments() {
		StringBuilder hql=new StringBuilder("from SegmentoProjeto");
		TypedQuery<SegmentoProjeto>query=session.createQuery(hql.toString(),SegmentoProjeto.class);
		return query.getResultList();
	}

	@Override
	public List<TipoProjeto> findAllProjectTypes() {
		StringBuilder hql=new StringBuilder("from TipoProjeto");
		TypedQuery<TipoProjeto>query=this.session.createQuery(hql.toString(),TipoProjeto.class);
		return query.getResultList();
	}
	
	@Override
	public List<TipoProduto> findAllProjectProductsTypes() {
		StringBuilder hql=new StringBuilder("from TipoProduto");
		TypedQuery<TipoProduto>query=session.createQuery(hql.toString(),TipoProduto.class);
		return query.getResultList();
	}
	
	@Override
	public List<TemaProjeto> findAllProjectSubjects() {
		StringBuilder hql=new StringBuilder("from TemaProjeto");
		TypedQuery<TemaProjeto>query=session.createQuery(hql.toString(),TemaProjeto.class);
		return query.getResultList();
	}
	
	@Override
	public List<SubtemaProjeto> findAllProjectSubsubjects() {
		StringBuilder hql=new StringBuilder("from SubtemaProjeto");
		TypedQuery<SubtemaProjeto>query=session.createQuery(hql.toString(),SubtemaProjeto.class);
		return query.getResultList();
	}
	
	@Override
	public List<FaseCadeiaInovacaoProjeto> findAllProjectInovationPhases() {
		StringBuilder hql=new StringBuilder("from FaseCadeiaInovacaoProjeto");
		TypedQuery<FaseCadeiaInovacaoProjeto>query=session.createQuery(hql.toString(),FaseCadeiaInovacaoProjeto.class);
		return query.getResultList();
	}

}
