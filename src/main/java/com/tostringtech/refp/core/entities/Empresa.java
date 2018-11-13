package com.tostringtech.refp.core.entities;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MapKeyClass;

@Entity
public class Empresa {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long cdEmpresa;
	@Column(nullable = false, unique = true)
	private String nrCnpj;
	@Column(nullable = false)
	private String razaoSocial;
	@Column(nullable = false)
	private String nomeFantasia;
	@Column(nullable = false)
	private String sigla;

	@ElementCollection(targetClass = Projeto.class)
	@MapKeyClass(String.class)
	private Map<String, Projeto> tpEmpresa=new HashMap<>();

	public Empresa() {
	
	}

	public Empresa(Long cdEmpresa, String nrCnpj, String razaoSocial, String nomeFantasia, String sigla) {
		this.cdEmpresa = cdEmpresa;
		this.nrCnpj = nrCnpj;
		this.razaoSocial = razaoSocial;
		this.nomeFantasia = nomeFantasia;
		this.sigla = sigla;
	}

	public Long getCdEmpresa() {
		return cdEmpresa;
	}

	public void setCdEmpresa(Long cdEmpresa) {
		this.cdEmpresa = cdEmpresa;
	}

	public String getNrCnpj() {
		return nrCnpj;
	}

	public void setNrCnpj(String nrCnpj) {
		this.nrCnpj = nrCnpj;
	}

	public String getRazaoSocial() {
		return razaoSocial;
	}

	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}

	public String getNomeFantasia() {
		return nomeFantasia;
	}

	public void setNomeFantasia(String nomeFantasia) {
		this.nomeFantasia = nomeFantasia;
	}

	public String getSigla() {
		return sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}

	public Map<String, Projeto> getTpEmpresa() {
		return tpEmpresa;
	}

	public void setTpEmpresa(Map<String, Projeto> tpEmpresa) {
		this.tpEmpresa = tpEmpresa;
	}

}
