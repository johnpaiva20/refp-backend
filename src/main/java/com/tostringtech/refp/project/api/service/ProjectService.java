package com.tostringtech.refp.project.api.service;

import com.tostringtech.refp.application.models.Projeto;
import com.tostringtech.refp.application.models.Subtema;
import com.tostringtech.refp.application.models.TipoProjeto;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Optional;

public interface ProjectService {

    Projeto create(Projeto projeto);

    Projeto update(Projeto projeto);

    Projeto delete(Projeto projeto);

    Optional<Projeto> findById(Long id);

    List<Projeto> findAll();

    List<TipoProjeto> listAllProjectTypes();
}
