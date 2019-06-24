package com.tostringtech.refp.projeto.api.repository;

import com.tostringtech.refp.application.model.*;

import java.util.List;

public interface ProjetoRepositoryCustom {

    List<Subtema> findAllSubtopicsByTopic(String type);

    List findAllTopicsByProjectType(String type);

    List<TipProj> listAllProjectTypes();

    List<FaseInova> listAllInnovationPhases();

    List<Produto> listAllProductsTypes();

    List<Segmento> listAllSegments();
}
