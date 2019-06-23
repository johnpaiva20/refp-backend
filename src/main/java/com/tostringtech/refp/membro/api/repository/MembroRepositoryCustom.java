package com.tostringtech.refp.membro.api.repository;

import com.tostringtech.refp.application.model.Membro;

import java.util.List;

public interface MembroRepositoryCustom {

    List<Membro> findByCodProjeto(Long codProjeto);
}
