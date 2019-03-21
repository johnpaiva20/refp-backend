package com.tostringtech.refp.categoria_contabil.service;

import com.tostringtech.refp.application.model.Recurso;
import org.springframework.data.domain.Page;

import java.util.List;

public interface RecursoService {

    Recurso create(Recurso recurso);

    void delete(Long codigo);

   // List<Recurso> findAll();

    Recurso findByCod(Long codigo);

   // Page<Recurso> findPage(Integer page, Integer linesPerPage, String orderBy, String direction);

    Recurso update(Recurso recurso);
}
