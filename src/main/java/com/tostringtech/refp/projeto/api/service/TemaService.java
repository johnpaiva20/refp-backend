package com.tostringtech.refp.projeto.api.service;

import java.util.List;

import com.tostringtech.refp.application.model.Subtema;

public interface TemaService {
	
	/**
     * Cadastro de Subtema
     * @param subtema
     * @return Subtema Cadastrado
     */
	
	Subtema create(Subtema subtema);
	
	List<Subtema> findAll();
}
