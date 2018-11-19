package com.tostringtech.refp.core.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import io.swagger.annotations.ApiModelProperty;

@Entity
public class TipoProduto implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	private String codTipoProduto;
	@Column
	private String descTipoProduto;

	public String getCodTipoProduto() {
		return codTipoProduto;
	}

	public void setCodTipoProduto(String codTipoProduto) {
		this.codTipoProduto = codTipoProduto;
	}

	public String getDescTipoProduto() {
		return descTipoProduto;
	}

	public void setDescTipoProduto(String descTipoProduto) {
		this.descTipoProduto = descTipoProduto;
	}

}
