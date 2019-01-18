package com.tostringtech.refp.core.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import io.swagger.annotations.ApiModelProperty;

@Entity()
@Table(name = "TITULACAO_MEMBRO")
public class TitulacaoMembro implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@ApiModelProperty(readOnly = true)
    @Column(name = "COD_TITULACAO_MEMBRO")
	private String codTitulacaoMembro;
    @Column(name = "DESC_TITULACAO_MEMBRO")
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
