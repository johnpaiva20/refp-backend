package com.tostringtech.refp.core.entities;

import java.io.Serializable;

import javax.persistence.*;

import io.swagger.annotations.ApiModelProperty;



@Entity
@Table(name = "RECURSO")
public class Recurso implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@ApiModelProperty(hidden = true)
	@Column(name = "COD_RECURSO")
	private long codRecurso;

	@Column(name = "DESC_RECURSO")
	private String descRecurso;
	@ManyToOne
	@JoinColumn(name = "COD_RUBRICA", foreignKey = @ForeignKey(name = "RECURSO_RUBRICA_FK"))
	private Rubrica rubrica;
	
	
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

	public Rubrica getRubrica() {
		return rubrica;
	}

	public void setRubrica(Rubrica rubrica) {
		this.rubrica = rubrica;
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
