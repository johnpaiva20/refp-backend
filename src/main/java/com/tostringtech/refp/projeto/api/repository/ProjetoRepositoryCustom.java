package com.tostringtech.refp.projeto.api.repository;

import com.tostringtech.refp.application.model.*;
import com.tostringtech.refp.projeto.api.rest.filters.ProjectTypeFilter;

import java.util.List;

public interface ProjetoRepositoryCustom {

    List<Subtema> findAllSubtopicsByTopic(String type);

    List findAllTopicsByProjectType(ProjectTypeFilter filter);

    List<TipoProjeto> listAllProjectTypes();

    /*List<FaseInova> listAllInnovationPhases();

    List<Produto> listAllProductsTypes();

    List<Segmento> listAllSegments();*/
}
