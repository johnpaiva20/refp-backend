package com.tostringtech.refp.core.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import io.swagger.annotations.ApiModelProperty;

@Entity
public class Rubrica implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@ApiModelProperty(hidden = true)
	private String codRubrica;
	
	@Column
	private String descRubrica;

	@ManyToOne(targetEntity = TipoProjeto.class)
	@JoinColumn(name = "codTipoProjeto")
	private TipoProjeto tpProjeto;

	@OneToMany
	@JsonIgnore
	@JoinTable(name = "recursos_rubrica", joinColumns = @JoinColumn(name = "codRubrica"), inverseJoinColumns = @JoinColumn(name = "codRecurso"))
	private List<Recurso> recursos = new ArrayList<>();

	
	public Rubrica() {}
	
	
	public Rubrica(String codRubrica, String descRubrica, TipoProjeto tpProjeto) {
		this.codRubrica = codRubrica;
		this.descRubrica = descRubrica;
		this.tpProjeto = tpProjeto;
	}


	public String getCodRubrica() {
		return codRubrica;
	}

	public void setCodRubrica(String codRubrica) {
		this.codRubrica = codRubrica;
	}

	public String getDescRubrica() {
		return descRubrica;
	}

	public void setDescRubrica(String descRubrica) {
		this.descRubrica = descRubrica;
	}


	public TipoProjeto getTpProjeto() {
		return tpProjeto;
	}


	public void setTpProjeto(TipoProjeto tpProjeto) {
		this.tpProjeto = tpProjeto;
	}


	public List<Recurso> getRecursos() {
		return recursos;
	}


	public void setRecursos(List<Recurso> recursos) {
		this.recursos = recursos;
	}
}
