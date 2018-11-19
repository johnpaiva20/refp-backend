package com.tostringtech.refp.core.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import io.swagger.annotations.ApiModelProperty;

@Entity
public class SubtemaProjeto implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@ApiModelProperty(readOnly = true)
	@Column
	private String codSubtemaProjeto;
	@Column
	private String descSubtemaProjeto;

	public String getCodSubtemaProjeto() {
		return codSubtemaProjeto;
	}

	public void setCodSubtemaProjeto(String codSubtemaProjeto) {
		this.codSubtemaProjeto = codSubtemaProjeto;
	}

	public String getDescSubtemaProjeto() {
		return descSubtemaProjeto;
	}

	public void setDescSubtemaProjeto(String descSubtemaProjeto) {
		this.descSubtemaProjeto = descSubtemaProjeto;
	}

}
