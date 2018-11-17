package com.tostringtech.refp.core.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import io.swagger.annotations.ApiModelProperty;

@Entity
public class TipoProjeto {

	@Id
	@ApiModelProperty(hidden = true)
	private String tpProjeto;

	@Column
	private String descTipoProjeto;

	@Column(length = 1)
	private String snAtivo;

	public String getTipoProjeto() {
		return tpProjeto;
	}

	public void setTipoProjeto(String codTipoProjeto) {
		this.tpProjeto = codTipoProjeto;
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
