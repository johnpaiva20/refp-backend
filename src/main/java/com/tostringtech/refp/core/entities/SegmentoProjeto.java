package com.tostringtech.refp.core.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import io.swagger.annotations.ApiModelProperty;

@Entity
public class SegmentoProjeto implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@ApiModelProperty(readOnly=true)
	private String codSegmento;
	@Column
	private String descSegmento;
	
	public String getCodSegmento() {
		return codSegmento;
	}
	public void setCodSegmento(String codSegmento) {
		this.codSegmento = codSegmento;
	}
	public String getDescSegmento() {
		return descSegmento;
	}
	public void setDescSegmento(String descSegmento) {
		this.descSegmento = descSegmento;
	}

}
