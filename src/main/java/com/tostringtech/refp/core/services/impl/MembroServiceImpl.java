package com.tostringtech.refp.core.services.impl;

import com.tostringtech.refp.core.repositories.MembroRepository;
import com.tostringtech.refp.core.services.MembroService;
import com.tostringtech.refp.core.entities.Membro;
import com.tostringtech.refp.api.resources.MemberResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MembroServiceImpl implements MembroService {

    @Autowired
    private MembroRepository membroRepositorio;

    @Override
    public MemberResource create(Membro membro) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public MemberResource create(MemberResource membro) {
        // TODO Auto-generated method stub
        //membroRepositorio.save(membro)
        return null;
    }

    @Override
    public MemberResource update(Membro membro) {
        // TODO Auto-generated method stub
        membroRepositorio.save(membro);
        return null;
    }

    @Override
    public List<MemberResource> findAll() {
        // TODO Auto-generated method stub
        List<MemberResource> resources = new ArrayList<>();
        membroRepositorio.findAll().forEach(membro -> {
            MemberResource resource = new MemberResource();

        });
        return resources;
    }

    @Override
    public List<MemberResource> findByCodProjeto(Long codProjeto) {
        // TODO Auto-generated method stub
        return membroRepositorio.findByCodProjeto(codProjeto).stream().map(membro -> new MemberResource()).collect(Collectors.toList());
    }

    @Override
    public void delete(Long codMembro) {
        // TODO Auto-generated method stub

    }

    @Override
    public MemberResource findById(Long codObj) {
        // TODO Auto-generated method stub
        Optional<Membro> m = membroRepositorio.findById(codObj);
        m.orElse(null);
        return null;
    }

    public MemberResource buildMemberResource(Membro membro) {
        // TODO Auto-generated method stub
        MemberResource resource = new MemberResource();
        return null;
    }

}
