package com.tostringtech.refp.core.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.tostringtech.refp.core.entities.Projeto;
import com.tostringtech.refp.core.repositories.dao.ProjetoHibernateDAO;

@Repository
public interface ProjetoRepository extends CrudRepository<Projeto, Long>, ProjetoHibernateDAO {

}
