package com.tostringtech.refp.core.repositories.custom;

import com.tostringtech.refp.core.entities.Empresa;
import com.tostringtech.refp.core.entities.relationships.EmpresaProjeto;

import java.util.List;

public interface EmpresaRepositoryCustom {
    List<EmpresaProjeto> findByCodProjeto(Long codProjeto);
}
