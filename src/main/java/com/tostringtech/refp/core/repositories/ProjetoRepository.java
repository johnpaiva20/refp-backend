package com.tostringtech.refp.core.repositories;

import com.tostringtech.refp.core.entities.Projeto;
import com.tostringtech.refp.core.repositories.custom.ProjetoRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjetoRepository extends JpaRepository<Projeto, Long>, ProjetoRepositoryCustom {






}
