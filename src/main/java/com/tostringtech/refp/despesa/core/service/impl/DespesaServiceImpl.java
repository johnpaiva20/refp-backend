package com.tostringtech.refp.despesa.core.service.impl;

import com.tostringtech.refp.despesa.api.repository.DespesaRepository;
import com.tostringtech.refp.despesa.api.service.DespesaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DespesaServiceImpl implements DespesaService {

	@Autowired
	private DespesaRepository despesaRepositorio;

}
