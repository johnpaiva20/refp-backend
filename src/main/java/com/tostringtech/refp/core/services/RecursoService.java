package com.tostringtech.refp.core.services;

import com.tostringtech.refp.core.entities.Recurso;

import java.util.List;

public interface RecursoService {

    Recurso create(Recurso recurso);

    Recurso update(Recurso recurso);

    void delete(Long codRubrica);

    Recurso findByCod(Long codRecurso);

    List<Recurso> findAll();
}
