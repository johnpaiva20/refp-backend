package com.tostringtech.refp.core.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import org.springframework.data.annotation.Id;

@Entity
public class Empresa {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Long cdEmpresa;
	@Column(nullable = false, unique = true)
	String nrCnpj;
	@Column(nullable = false)
	String razaoSocial;
	@Column(nullable = false)
	String nomeFantasia;
	@Column(nullable = false)
	String sigla;

}
