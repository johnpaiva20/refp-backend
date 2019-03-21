package com.tostringtech.refp.projeto.repository;

import com.tostringtech.refp.application.model.Projeto;
import com.tostringtech.refp.projeto.repository.custom.ProjetoRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjetoRepository extends JpaRepository<Projeto, Long>, ProjetoRepositoryCustom {






}
