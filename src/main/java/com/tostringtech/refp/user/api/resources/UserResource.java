package com.tostringtech.refp.user.api.resources;

import com.tostringtech.refp.application.models.Usuario;

import io.swagger.annotations.ApiModel;

@ApiModel(value = "User")
public class UserResource {
	
	private Long id;
	
	private String email;

	private String password;
	
	public UserResource() {
	}
	
	public UserResource(Usuario usuario) {
		this.setId(usuario.getId());
		this.setEmail(usuario.getEmail());
		this.setPassword(usuario.getPassword());
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
