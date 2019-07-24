package com.tostringtech.refp.projeto.api.repository.custom;

import com.tostringtech.refp.application.models.Subtema;
import com.tostringtech.refp.application.models.TipoProduto;
import com.tostringtech.refp.application.models.TipoProjeto;
import com.tostringtech.refp.projeto.api.rest.filters.TopicFilter;

import java.util.List;

public interface ProjetoRepositoryCustom {

    List<Subtema> findAllSubtopicsByTopic(String type);

    List findAllTopicsByProjectType(TopicFilter filter);

    List<TipoProjeto> listAllProjectTypes();

    List<TipoProduto> listProductsTypes();

    /*List<FaseInova> listAllInnovationPhases();

    List<Segmento> listAllSegments();*/
}
