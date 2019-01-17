package com.tostringtech.refp.core.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name = "RUBRICA")
public class Rubrica implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@ApiModelProperty(hidden = true)
    @Column(name = "COD_RUBRICA")
	private String codRubrica;

    @Column(name = "DESC_RUBRICA")
	private String descRubrica;

	@ManyToOne(targetEntity = TipoProjeto.class)
    @JoinColumn(name = "COD_TIPO_PROJETO", foreignKey = @ForeignKey(name = "RUBRICA_TIPO_PROJETO_FK"))
	private TipoProjeto tpProjeto;

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

}
