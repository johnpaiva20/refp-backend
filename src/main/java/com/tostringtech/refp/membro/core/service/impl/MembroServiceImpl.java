package com.tostringtech.refp.membro.core.service.impl;

import com.tostringtech.refp.membro.api.repository.MembroRepository;
import com.tostringtech.refp.membro.api.service.MembroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MembroServiceImpl implements MembroService {

    @Autowired
    private MembroRepository membroRepositorio;



}
