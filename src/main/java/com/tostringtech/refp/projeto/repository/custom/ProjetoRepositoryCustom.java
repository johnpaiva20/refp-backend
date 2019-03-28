package com.tostringtech.refp.projeto.repository.custom;

import com.tostringtech.refp.application.model.Subtema;

import java.util.List;

public interface ProjetoRepositoryCustom {

    List<Subtema> findAllSubtopicsByTopic(String type);

    List findAllTopicsByProjectType(String type);
}
