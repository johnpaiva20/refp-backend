package com.tostringtech.refp.core.services;

import com.tostringtech.refp.core.entities.Despesa;
import com.tostringtech.refp.api.resources.ExpenseResource;

import java.util.List;

public interface DespesaService {

    ExpenseResource create(Despesa despesa);

    ExpenseResource create(ExpenseResource despesa);

    ExpenseResource update(Despesa despesa);

    void delete(Long codObj);

    ExpenseResource findByCod(Long codObj);

    List<ExpenseResource> findAll();
}
