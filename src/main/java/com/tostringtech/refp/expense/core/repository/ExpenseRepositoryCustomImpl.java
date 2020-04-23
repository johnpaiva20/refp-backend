<<<<<<< HEAD
package com.tostringtech.refp.expense.core.repository;

import com.tostringtech.refp.expense.api.repository.custom.ExpenseRepositoryCustom;

//import javax.persistence.EntityManager;
//import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

@Repository
@Transactional
public class ExpenseRepositoryCustomImpl implements ExpenseRepositoryCustom {
    
//	@PersistenceContext
//    private EntityManager entityManager;
	
	
}
=======
package com.tostringtech.refp.expense.core.repository;

import com.tostringtech.refp.expense.api.repository.custom.ExpenseRepositoryCustom;
import org.springframework.stereotype.Repository;

@Repository
public class ExpenseRepositoryCustomImpl implements ExpenseRepositoryCustom {
}
>>>>>>> 65bf307dfdf65769f165a97dda841d4e2cc34860
