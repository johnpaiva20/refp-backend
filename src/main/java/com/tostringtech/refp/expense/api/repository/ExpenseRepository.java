package com.tostringtech.refp.expense.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tostringtech.refp.application.models.Despesa;
import com.tostringtech.refp.application.models.Projeto;
import com.tostringtech.refp.expense.api.repository.custom.ExpenseRepositoryCustom;

public interface ExpenseRepository extends JpaRepository<Despesa,Long>, ExpenseRepositoryCustom {
	
	List<Despesa> findAllByProjeto(Projeto projeto);
}
