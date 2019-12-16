package com.tostringtech.refp.project.api.repository.custom;

import com.tostringtech.refp.application.models.Subtema;
import com.tostringtech.refp.application.models.TipoProduto;
import com.tostringtech.refp.application.models.TipoProjeto;

import java.util.List;

public interface ProjectRepositoryCustom {
    List<TipoProjeto> listAllProjectTypes();

    List<Subtema> findAllSubtopicsByTopic(Long tema);

    List<TipoProduto> listProductsTypes();
}
