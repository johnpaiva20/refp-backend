package com.tostringtech.refp.user.api.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.tostringtech.refp.application.models.Usuario;
import com.tostringtech.refp.user.api.repository.custom.UserRepositoryCustom;

public interface UserRepository extends JpaRepository<Usuario, Long>, UserRepositoryCustom {
	
	Usuario findByEmail(String email);

}
