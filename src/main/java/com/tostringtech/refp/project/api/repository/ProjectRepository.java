package com.tostringtech.refp.project.api.repository;

import com.tostringtech.refp.application.models.Projeto;
import com.tostringtech.refp.project.api.repository.custom.ProjectRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepository extends JpaRepository<Projeto, Long>, ProjectRepositoryCustom {
}
