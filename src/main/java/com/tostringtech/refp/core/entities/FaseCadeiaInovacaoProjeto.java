package com.tostringtech.refp.core.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "FASE_CADEIA_INOVACAO")
public class FaseCadeiaInovacaoProjeto {
	@Id
    @Column(name = "COD_FASE_CADEIA")
	private String codFaseCadeia;
    @Column(name = "DESC_FASE_CADEIA")
	private String descFaseCadeia;
	
	
	public FaseCadeiaInovacaoProjeto(String codFaseCadeia, String descFaseCadeia) {
		super();
		this.codFaseCadeia = codFaseCadeia;
		this.descFaseCadeia = descFaseCadeia;
	}

    public FaseCadeiaInovacaoProjeto(String codFaseCadeia) {
        super();
        this.codFaseCadeia = codFaseCadeia;
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
