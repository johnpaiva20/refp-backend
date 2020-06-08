package com.tostringtech.refp.user.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.tostringtech.refp.application.models.Usuario;
import com.tostringtech.refp.user.api.resources.UserResource;
import com.tostringtech.refp.user.api.service.UserService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Api(tags = "User")
public class UserRestController {
	
	@Autowired
	private UserService service;
	
//	@Autowired
//	private BCryptPasswordEncoder pe = new BCryptPasswordEncoder();
	
	@PostMapping("/user")
    @ApiOperation(tags = {"User"}, value = "Cadastrar um novo Usuário")
	public ResponseEntity<UserResource> createUser(@RequestBody UserResource resource){
//		resource.setPassword(pe.encode(resource.getPassword()));
		Usuario usuario = service.create(new Usuario(resource));
		resource = new UserResource(usuario);
		return new ResponseEntity<>(resource, HttpStatus.CREATED);
	}
	
	
	

}
