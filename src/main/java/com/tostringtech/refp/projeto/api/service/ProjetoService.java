package com.tostringtech.refp.projeto.api.service;

import com.tostringtech.refp.application.model.*;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Optional;

public interface ProjetoService {

    Projeto create(Projeto projeto);

    List<Projeto> findAll();

    List<Subtema> findAllSubtopicsByTopic(String topic);

    List<Tema> findAllTopicsByProjectType(String type);

    Optional<Projeto> findById(Long id);

    Page<Projeto> findPage(Integer page, Integer linesPerPage, String orderBy, String direction);

    Projeto update(Projeto projeto);

    List<Segmento> listAllSegments();

    List<Produto> listAllProductsTypes();

    List<FaseInova> listAllInnovationPhases();

    List<TipPro> listAllProjectTypes();
}