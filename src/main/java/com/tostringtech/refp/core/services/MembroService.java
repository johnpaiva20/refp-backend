package com.tostringtech.refp.core.services;

import com.tostringtech.refp.core.entities.Membro;

import java.util.List;

public interface MembroService extends IServices<Membro> {


    List<Membro> findByCodProjeto(Long codProjeto);
}
