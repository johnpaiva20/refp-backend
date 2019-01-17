package com.tostringtech.refp.core.services;

import com.tostringtech.refp.core.entities.Membro;
import com.tostringtech.refp.api.resources.MemberResource;

import java.util.List;

public interface MembroService {


    MemberResource create(Membro membro);

    MemberResource create(MemberResource membro);

    MemberResource update(Membro membro);

    List<MemberResource> findAll();

    List<MemberResource> findByCodProjeto(Long codProjeto);

    void delete(Long codMembro);

    MemberResource findById(Long codMembro);
}
