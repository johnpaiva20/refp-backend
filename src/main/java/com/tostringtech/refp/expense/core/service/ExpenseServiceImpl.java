<<<<<<< HEAD
package com.tostringtech.refp.expense.core.service;

import com.tostringtech.refp.application.exceptions.ObjectNotFoundException;
import com.tostringtech.refp.application.models.Despesa;
import com.tostringtech.refp.expense.api.repository.ExpenseRepository;
import com.tostringtech.refp.expense.api.service.ExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
	public Despesa update(Despesa despesa) {
		findById(despesa.getCodigo());
		return expenseRepository.save(despesa);
	}
	
	@Override
	public void delete(Long id) {
		Despesa despesa = expenseRepository.findById(id).orElseThrow(() -> {
            return new ObjectNotFoundException("Despesa não encontrada");
        });
		expenseRepository.delete(despesa);
	}
}
=======
package com.tostringtech.refp.expense.core.service;

import com.tostringtech.refp.application.models.Despesa;
import com.tostringtech.refp.expense.api.repository.ExpenseRepository;
import com.tostringtech.refp.expense.api.service.ExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ExpenseServiceImpl implements ExpenseService {

    @Autowired
    private ExpenseRepository expenseRepository;

    @Override
    public Despesa create(Despesa despesa) {
        return expenseRepository.save(despesa);
    }

    @Override
    public List<Despesa> findAll() {
        return expenseRepository.findAll();
    }

    @Override
    public Optional<Despesa> findById(Long id) {
        return expenseRepository.findById(id);
    }
}
>>>>>>> 65bf307dfdf65769f165a97dda841d4e2cc34860
