package com.tostringtech.refp.core.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import io.swagger.annotations.ApiModelProperty;

@Entity
public class Rubrica implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@ApiModelProperty(hidden = true)
	private long codRubrica;
	@Column
	private String descRubrica;

	public Rubrica() {
	}
	
	public Rubrica(long codRubrica, String descRubrica) {
		this.codRubrica = codRubrica;
		this.descRubrica = descRubrica;
	}

	public long getCodRubrica() {
		return codRubrica;
	}

	public void setCodRubrica(long codRubrica) {
		this.codRubrica = codRubrica;
	}

	public String getDescRubrica() {
		return descRubrica;
	}

	public void setDescRubrica(String descRubrica) {
		this.descRubrica = descRubrica;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (codRubrica ^ (codRubrica >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Rubrica other = (Rubrica) obj;
		if (codRubrica != other.codRubrica)
			return false;
		return true;
	}
	


	

}
