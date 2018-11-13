package com.tostringtech.refp.core.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Recurso implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long cod_recurso;
	@Column
	private String desc_recurso;
	@ManyToOne
	private Rubrica rubrica;
	
	public Recurso() {}

	public Recurso(long cod_recurso, String desc_recurso, Rubrica rubrica) {
		this.cod_recurso = cod_recurso;
		this.desc_recurso = desc_recurso;
		this.rubrica = rubrica;
	}

	public long getCod_recurso() {
		return cod_recurso;
	}

	public void setCod_recurso(long cod_recurso) {
		this.cod_recurso = cod_recurso;
	}

	public String getDesc_recurso() {
		return desc_recurso;
	}

	public void setDesc_recurso(String desc_recurso) {
		this.desc_recurso = desc_recurso;
	}

	public Rubrica getRubrica() {
		return rubrica;
	}

	public void setRubrica(Rubrica rubrica) {
		this.rubrica = rubrica;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (cod_recurso ^ (cod_recurso >>> 32));
		result = prime * result + ((desc_recurso == null) ? 0 : desc_recurso.hashCode());
		result = prime * result + ((rubrica == null) ? 0 : rubrica.hashCode());
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
		Recurso other = (Recurso) obj;
		if (cod_recurso != other.cod_recurso)
			return false;
		if (desc_recurso == null) {
			if (other.desc_recurso != null)
				return false;
		} else if (!desc_recurso.equals(other.desc_recurso))
			return false;
		if (rubrica == null) {
			if (other.rubrica != null)
				return false;
		} else if (!rubrica.equals(other.rubrica))
			return false;
		return true;
	}
	
	

	

	
}
