package com.tostringtech.refp.repositories.custom.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Service;

import com.tostringtech.refp.repositories.custom.ProjetoRepositoryCustom;

@Service
public class ProjetoRepositoryCustomImpl implements ProjetoRepositoryCustom {

	@PersistenceContext
	private EntityManager session;

	/*public List<Projeto> getAllProjectsInicialized() {
		StringBuilder hql=new StringBuilder();
		hql.append("from Projeto");
		TypedQuery<Projeto>query=session.createQuery(hql.toString(), Projeto.class);
		return query.getResultList();
	}*/

}
