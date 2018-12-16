package com.tostringtech.refp.core.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity

public class FaseCadeiaInovacaoProjeto {
	@Id
	private String codFaseCadeia;
	@Column
	private String descFaseCadeia;
	
	
	public FaseCadeiaInovacaoProjeto(String codFaseCadeia, String descFaseCadeia) {
		super();
		this.codFaseCadeia = codFaseCadeia;
		this.descFaseCadeia = descFaseCadeia;
	}
	
	public FaseCadeiaInovacaoProjeto() {
	}

	public String getCodFaseCadeia() {
		return codFaseCadeia;
	}
	public void setCodFaseCadeia(String codFaseCadeia) {
		this.codFaseCadeia = codFaseCadeia;
	}
	public String getDescFaseCadeia() {
		return descFaseCadeia;
	}
	public void setDescFaseCadeia(String descFaseCadeia) {
		this.descFaseCadeia = descFaseCadeia;
	}
	
}
