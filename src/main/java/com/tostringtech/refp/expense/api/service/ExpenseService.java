package com.tostringtech.refp.expense.api.service;

import com.tostringtech.refp.application.models.Despesa;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public interface ExpenseService {

    Despesa create(Despesa despesa);

    List<Despesa> findAll();

    Optional<Despesa> findById(Long id);
}
