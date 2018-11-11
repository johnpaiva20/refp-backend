package com.tostringtech.refp.core.entities;

import java.util.Calendar;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MapKeyClass;

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

	@ElementCollection(targetClass = Projeto.class)
	@MapKeyClass(String.class)
	private Map<String, Projeto> descTitulacao;
	
	@ElementCollection(targetClass = Projeto.class)
	@MapKeyClass(Boolean.class)
	private Map<Boolean, Projeto> snAtivo;

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

	public Calendar getDtNascimento() {
		return dtNascimento;
	}

	public void setDtNascimento(Calendar dtNascimento) {
		this.dtNascimento = dtNascimento;
	}

	public Map<String, Projeto> getDescTitulacao() {
		return descTitulacao;
	}

	public void setDescTitulacao(Map<String, Projeto> descTitulacao) {
		this.descTitulacao = descTitulacao;
	}

}
