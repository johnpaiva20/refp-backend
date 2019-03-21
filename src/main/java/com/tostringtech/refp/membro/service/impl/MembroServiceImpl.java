package com.tostringtech.refp.membro.service.impl;

import com.tostringtech.refp.membro.repository.MembroRepository;
import com.tostringtech.refp.membro.service.MembroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MembroServiceImpl implements MembroService {

    @Autowired
    private MembroRepository membroRepositorio;



}
