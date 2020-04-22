package com.tostringtech.refp.expense.api.repository;

import com.tostringtech.refp.application.models.Despesa;
import com.tostringtech.refp.expense.api.repository.custom.ExpenseRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExpenseRepository extends JpaRepository<Despesa,Long>, ExpenseRepositoryCustom {
}
