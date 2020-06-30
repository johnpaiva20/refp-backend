package com.tostringtech.refp.expense.core.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.tostringtech.refp.application.exceptions.ObjectNotFoundException;
import com.tostringtech.refp.application.models.Despesa;
import com.tostringtech.refp.application.models.Projeto;
import com.tostringtech.refp.expense.api.repository.ExpenseRepository;
import com.tostringtech.refp.expense.api.service.ExpenseService;

@Service
public class ExpenseServiceImpl implements ExpenseService {

    @Autowired
    private ExpenseRepository expenseRepository;

    @Override
    public Despesa create(Despesa despesa) {
        return expenseRepository.save(despesa);
    }

    @Override
    public Optional<Despesa> findById(Long id) {
        return expenseRepository.findById(id);
    }

	@Override
	public List<Despesa> findAll(Pageable pageable) {
		return expenseRepository.findAll(pageable).toList();
	}
	
	@Override
	public List<Despesa> findAllByProject(Projeto projeto) {
		return expenseRepository.findAllByProjeto(projeto);
	}

	@Override
	public Despesa update(Despesa despesa) {
		findById(despesa.getCodigo());
		return expenseRepository.save(despesa);
	}
	
	@Override
	public void delete(Long id) {
		Despesa despesa = expenseRepository.findById(id).orElseThrow(() -> {
            return new ObjectNotFoundException("Despesa n�o encontrada");
        });
		expenseRepository.delete(despesa);
	}

	@Override
	public List<Despesa> findAll() {
		return expenseRepository.findAll();
	}
}
