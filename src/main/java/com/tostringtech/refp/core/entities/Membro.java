package com.tostringtech.refp.core.entities;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MapKeyClass;

@Entity
public class Membro {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long codMembro;
	@Column(nullable = false, unique = true)
	private String nrMatricula;
	@Column(nullable = false)
	private String nmMembro;
	@Column(nullable = false, unique = true)
	private String nrCpf;
	@Column(nullable = false)
	private String email;
	@Column(nullable = false)
	private String nrTelefone;
	@Column(nullable = false)
	private Date dtNascimento;

	@ElementCollection(targetClass = String.class)
	@MapKeyClass(Projeto.class)
	private Map<Projeto, String> descTitulacao=new HashMap<>();
	
	@ElementCollection(targetClass = Boolean.class)
	@MapKeyClass(Projeto.class)
	private Map<Projeto, Boolean> snAtivo=new HashMap<>();

	public Membro() {
		
	}
	

	public Membro(Long codMembro, String nrMatricula, String nmMembro, String nrCpf, String email, String nrTelefone,
			Date dtNascimento) {
		this.codMembro = codMembro;
		this.nrMatricula = nrMatricula;
		this.nmMembro = nmMembro;
		this.nrCpf = nrCpf;
		this.email = email;
		this.nrTelefone = nrTelefone;
		this.dtNascimento = dtNascimento;
	}


	public Long getCodMembro() {
		return codMembro;
	}

	public void setCodMembro(Long codMembro) {
		this.codMembro = codMembro;
	}

	public String getNrMatricula() {
		return nrMatricula;
	}

	public void setNrMatricula(String nrMatricula) {
		this.nrMatricula = nrMatricula;
	}

	public String getNmMembro() {
		return nmMembro;
	}

	public void setNmMembro(String nmMembro) {
		this.nmMembro = nmMembro;
	}

	public String getNrCpf() {
		return nrCpf;
	}

	public void setNrCpf(String nrCpf) {
		this.nrCpf = nrCpf;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNrTelefone() {
		return nrTelefone;
	}

	public void setNrTelefone(String nrTelefone) {
		this.nrTelefone = nrTelefone;
	}

	public Date getDtNascimento() {
		return dtNascimento;
	}

	public void setDtNascimento(Date dtNascimento) {
		this.dtNascimento = dtNascimento;
	}

	public Map<Projeto, String> getDescTitulacao() {
		return descTitulacao;
	}

	public void setDescTitulacao(Map<Projeto, String> descTitulacao) {
		this.descTitulacao = descTitulacao;
	}

	public Map<Projeto, Boolean> getSnAtivo() {
		return snAtivo;
	}

	public void setSnAtivo(Map<Projeto, Boolean> snAtivo) {
		this.snAtivo = snAtivo;
	}

}
