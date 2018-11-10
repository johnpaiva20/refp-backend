package com.tostringtech.refp.core.entities;

import java.util.Calendar;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;



@Entity
public class Membro {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Long codMembro;
	@Column(nullable = false, unique = true)
	String nrMatricula;
	@Column(nullable = false)
	String nmMembro;
	@Column(nullable = false, unique = true)
	String nrCpf;
	@Column(nullable = false)
	String email;
	@Column(nullable = false)
	String nrTelefone;
	@Column(nullable = false)
	Calendar dtNascimento;
	@Column(nullable = false)
	String descTitulacao;
}
