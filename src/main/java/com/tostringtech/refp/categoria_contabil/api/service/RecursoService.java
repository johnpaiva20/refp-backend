package com.tostringtech.refp.categoria_contabil.api.service;

import com.tostringtech.refp.application.models.Recurso;
import org.springframework.data.domain.Page;

public interface RecursoService {

    Recurso create(Recurso recurso);

    void delete(Long codigo);

    Recurso findByCod(Long codigo);

    Page<Recurso> findPage(Integer page, Integer linesPerPage, String orderBy, String direction);

    Recurso update(Recurso recurso);
}
