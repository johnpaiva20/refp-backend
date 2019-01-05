package com.tostringtech.refp.core.repositories;

import com.tostringtech.refp.core.entities.Membro;
import com.tostringtech.refp.core.repositories.dao.MembroHibernateDAO;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MembroRepository extends CrudRepository<Membro, Long>, MembroHibernateDAO {

}
