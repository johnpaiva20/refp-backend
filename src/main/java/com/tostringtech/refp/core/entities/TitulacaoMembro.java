package com.tostringtech.refp.core.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import io.swagger.annotations.ApiModelProperty;

@Entity()
public class TitulacaoMembro implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@ApiModelProperty(readOnly = true)
	private String codTitulacaoMembro;
	@Column
	private String descTitulacaoMembro;

	public String getCodTitulacaoMembro() {
		return codTitulacaoMembro;
	}

	public void setCodTitulacaoMembro(String codTitulacaoMembro) {
		this.codTitulacaoMembro = codTitulacaoMembro;
	}

	public String getDescTitulacaoMembro() {
		return descTitulacaoMembro;
	}

	public void setDescTitulacaoMembro(String descTitulacaoMembro) {
		this.descTitulacaoMembro = descTitulacaoMembro;
	}

}
