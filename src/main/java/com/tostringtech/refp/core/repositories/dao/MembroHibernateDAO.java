package com.tostringtech.refp.core.repositories.dao;

import com.tostringtech.refp.core.entities.Membro;

import java.util.List;

public interface MembroHibernateDAO {
    List<Membro> findByCodProjeto(Long codProjeto);
}
