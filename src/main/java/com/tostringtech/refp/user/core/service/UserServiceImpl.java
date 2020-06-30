package com.tostringtech.refp.user.core.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.tostringtech.refp.application.models.Usuario;
import com.tostringtech.refp.user.api.repository.UserRepository;
import com.tostringtech.refp.user.api.service.UserService;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepository repo;
	
	@Override
	public Usuario create(Usuario usuario) {
		return repo.save(usuario);
	}

	@Override
	public List<Usuario> findAll(Pageable pageable) {
		return repo.findAll(pageable).toList();
	}

	@Override
	public Usuario findByEmail(String email) {
		return repo.findByEmail(email);
	}

}
