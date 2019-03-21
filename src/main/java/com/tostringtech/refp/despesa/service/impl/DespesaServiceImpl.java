package com.tostringtech.refp.despesa.service.impl;

import com.tostringtech.refp.despesa.repository.DespesaRepository;
import com.tostringtech.refp.despesa.service.DespesaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DespesaServiceImpl implements DespesaService {

	@Autowired
	private DespesaRepository despesaRepositorio;

}
