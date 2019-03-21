package com.tostringtech.refp.projeto.service;

import com.tostringtech.refp.application.model.Projeto;

import java.util.List;
import java.util.Optional;

public interface ProjetoService {

    Projeto create(Projeto projeto);

    List<Projeto> findAll();


    Optional<Projeto> findById(Long id);
}