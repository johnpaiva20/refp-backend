package com.tostringtech.refp.application.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.tostringtech.refp.user.api.resources.UserResource;

@Entity
@Table(name = "USUARIO")
public class Usuario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String email;
	
	private String password;

	public Usuario() {
		
	}
	
	public Usuario(UserResource resource) {
		this.setId(resource.getId());
		this.setEmail(resource.getEmail());
		this.setPassword(resource.getPassword());
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
