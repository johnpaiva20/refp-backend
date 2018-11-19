package com.tostringtech.refp.core.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import io.swagger.annotations.ApiModelProperty;

@Entity
public class TemaProjeto implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@ApiModelProperty(readOnly = true)
	private String codTema;
	@Column
	private String descTema;

	@ManyToOne()
	@ApiModelProperty()
	@JoinColumn(name="codTipoProjeto")
	private TipoProjeto codTipoProjeto;

	public String getCodTema() {
		return codTema;
	}

	public void setCodTema(String codTema) {
		this.codTema = codTema;
	}

	public String getDescTema() {
		return descTema;
	}

	public void setDescTema(String descTema) {
		this.descTema = descTema;
	}

	public TipoProjeto getCodTipoProjeto() {
		return codTipoProjeto;
	}

	public void setCodTipoProjeto(TipoProjeto codTipoProjeto) {
		this.codTipoProjeto = codTipoProjeto;
	}

	// private Set<SubtemaProjeto> subtemas;
	
}
