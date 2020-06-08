package com.tostringtech.refp.expense.api.service;

import com.tostringtech.refp.application.models.Despesa;
import com.tostringtech.refp.application.models.Projeto;

import java.util.List;
import java.util.Optional;
import org.springframework.data.domain.Pageable;

public interface ExpenseService {

    Despesa create(Despesa despesa);

    List<Despesa> findAll(Pageable pageable);
    
    List<Despesa> findAllByProject(Projeto projeto);

    Optional<Despesa> findById(Long id);
    
    Despesa update(Despesa projeto);

	void delete(Long id);
}
