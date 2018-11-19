package com.tostringtech.refp.core.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import io.swagger.annotations.ApiModelProperty;

@Entity
public class TipoProjeto implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@ApiModelProperty()
	private String codTipoProjeto;

	@Column
	@ApiModelProperty(readOnly=true)
	private String descTipoProjeto;

	@Column(length = 1)
	@ApiModelProperty(readOnly=true)
	private String snAtivo;

	public String getCodTipoProjeto() {
		return codTipoProjeto;
	}

	public void setCodTipoProjeto(String codTipoProjeto) {
		this.codTipoProjeto = codTipoProjeto;
	}

	public String getDescTipoProjeto() {
		return descTipoProjeto;
	}

	public void setDescTipoProjeto(String descTipoProjeto) {
		this.descTipoProjeto = descTipoProjeto;
	}

	public String getSnAtivo() {
		return snAtivo;
	}

	public void setSnAtivo(String snAtivo) {
		this.snAtivo = snAtivo;
	}

	
	
}
