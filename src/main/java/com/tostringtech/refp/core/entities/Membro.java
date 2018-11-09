package com.tostringtech.refp.core.entities;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import org.springframework.data.annotation.Id;

@Entity
public class Membro {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Long cdMembro;
	@Column(nullable = false, unique = true)
	String nrMatricula;
	@Column(nullable = false)
	String nmMembro;
	@Column(nullable = false, unique = true)
	String nrCpf;
	@Column(nullable = false)
	String email;
	@Column(nullable = false)
	String nmTelefone;
	@Column(nullable = false)
	Calendar dtNascimento;
	@Column(nullable = false)
	String titulacao;
	// Empresa empresa;
	
}
