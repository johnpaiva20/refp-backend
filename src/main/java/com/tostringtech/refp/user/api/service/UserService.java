package com.tostringtech.refp.user.api.service;

import com.tostringtech.refp.application.models.Usuario;

import java.util.List;
import org.springframework.data.domain.Pageable;

public interface UserService {
	
	Usuario create(Usuario usuario);
	
	List<Usuario> findAll(Pageable pageable);
	
	Usuario findByEmail(String email);

}
