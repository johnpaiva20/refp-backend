package com.tostringtech.refp.core.repositories.custom;

import com.tostringtech.refp.core.entities.Membro;

import java.util.List;

public interface MembroRepositoryCustom {

    List<Membro> findByCodProjeto(Long codProjeto);
}
