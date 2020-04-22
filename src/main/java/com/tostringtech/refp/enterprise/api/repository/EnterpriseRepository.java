package com.tostringtech.refp.enterprise.api.repository;

import com.tostringtech.refp.application.models.Empresa;
import com.tostringtech.refp.enterprise.api.repository.custom.EnterpriseRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnterpriseRepository extends JpaRepository<Empresa,Long>, EnterpriseRepositoryCustom {
}
