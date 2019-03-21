package com.tostringtech.refp.projeto.service.impl;

import com.tostringtech.refp.application.model.Projeto;
import com.tostringtech.refp.projeto.repository.ProjetoRepository;
import com.tostringtech.refp.projeto.service.ProjetoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProjetoServiceImpl implements ProjetoService {

    @Autowired
    private ProjetoRepository projetoRepository;

    @Override
    public Projeto create(Projeto projeto) {
        return projetoRepository.save(projeto);
    }

    @Override
    public List<Projeto> findAll() {
        return projetoRepository.findAll();
    }

    @Override
    public Optional<Projeto> findById(Long id) {
        return projetoRepository.findById(id);
    }


}
