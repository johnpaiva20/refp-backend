package com.tostringtech.refp.projeto.api.service;

import com.tostringtech.refp.application.models.*;
import com.tostringtech.refp.projeto.api.rest.filters.TopicFilter;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Optional;

public interface ProjetoService {

    /**
     * Cadastro de Projeto
     * @param projeto
     * @return Projeto Cadastrado
     */
    Projeto create(Projeto projeto) ;

    List<Projeto> findAll();

    List<Subtema> findAllSubtopicsByTopic(String topic);

    List<Tema> findAllTopicsByProjectType(TopicFilter filter);

    Optional<Projeto> findById(Long id);

    Page<Projeto> findPage(Integer page, Integer linesPerPage, String orderBy, String direction);

    Projeto update(Projeto projeto);

    List<TipoProjeto> listAllProjectTypes();

    List<TipoProduto> listProductTypes();

   /* List<Segmento> listAllSegments();

    List<Produto> listAllProductsTypes();

    List<FaseInova> listAllInnovationPhases();*/
}