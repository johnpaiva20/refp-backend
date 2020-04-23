<<<<<<< HEAD
package com.tostringtech.refp.expense.api.service;

import com.tostringtech.refp.application.models.Despesa;

import java.util.List;
import java.util.Optional;
import org.springframework.data.domain.Pageable;

public interface ExpenseService {

    Despesa create(Despesa despesa);

    List<Despesa> findAll(Pageable pageable);

    Optional<Despesa> findById(Long id);
    
    Despesa update(Despesa projeto);

	void delete(Long id);
}
=======
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
>>>>>>> 65bf307dfdf65769f165a97dda841d4e2cc34860
