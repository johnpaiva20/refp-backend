package com.tostringtech.refp.core.entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Recurso implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long codRecurso;
	@Column
	private String descRecurso;
	
	public Recurso() {}

	public Recurso(long codRecurso, String descRecurso) {
		this.codRecurso = codRecurso;
		this.descRecurso = descRecurso;
	}

	public long getCodRecurso() {
		return codRecurso;
	}

	public void setCodRecurso(long codRecurso) {
		this.codRecurso = codRecurso;
	}

	public String getDescRecurso() {
		return descRecurso;
	}

	public void setDescRecurso(String descRecurso) {
		this.descRecurso = descRecurso;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (codRecurso ^ (codRecurso >>> 32));
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
		if (codRecurso != other.codRecurso)
			return false;
		return true;
	}



	

	
}
