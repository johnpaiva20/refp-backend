package com.tostringtech.refp.projeto.api.repository;

import com.tostringtech.refp.application.model.Projeto;
import com.tostringtech.refp.projeto.api.repository.custom.ProjetoRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjetoRepository extends JpaRepository<Projeto, Long>, ProjetoRepositoryCustom {






}
