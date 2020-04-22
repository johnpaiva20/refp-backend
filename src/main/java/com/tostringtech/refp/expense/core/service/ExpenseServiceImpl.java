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
