package com.tostringtech.refp.core.services.impl;

import com.tostringtech.refp.core.repositories.DespesaRepository;
import com.tostringtech.refp.core.services.DespesaService;
import com.tostringtech.refp.core.entities.Despesa;
import com.tostringtech.refp.api.resources.ExpenseResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DespesaServiceImpl implements DespesaService {

	@Autowired
	private DespesaRepository despesaRepositorio;

	@Override
    public ExpenseResource create(Despesa despesa) {
        // TODO Auto-generated method stub
        despesaRepositorio.save(despesa);
        return null;
    }

    @Override
    public ExpenseResource create(ExpenseResource despesa) {
        // TODO Auto-generated method stub
        //despesaRepositorio.save(despesa);
        return null;
	}

	@Override
    public ExpenseResource update(Despesa obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Long codObj) {
		// TODO Auto-generated method stub
	}

	@Override
    public ExpenseResource findByCod(Long codObj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
    public List<ExpenseResource> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
