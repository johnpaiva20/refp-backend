package com.tostringtech.refp.core.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;

@Entity
public class Rubrica implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long cod_rubrica;
	@Column
	private String desc_rubrica;
	@OneToMany
	@JoinTable(
			name="Rubrica_Recurso",
			joinColumns = @JoinColumn(name="cod_rubrica"),
			inverseJoinColumns = @JoinColumn(name="cod_recurso")
			)
	private List<Recurso> recursos = new ArrayList<Recurso>();

	public Rubrica() {
	}

	public Rubrica(long cod_rubrica, String desc_rubrica) {
		this.cod_rubrica = cod_rubrica;
		this.desc_rubrica = desc_rubrica;
	}

	public long getCod_rubrica() {
		return cod_rubrica;
	}

	public void setCod_rubrica(long cod_rubrica) {
		this.cod_rubrica = cod_rubrica;
	}

	public String getDesc_rubrica() {
		return desc_rubrica;
	}

	public void setDesc_rubrica(String desc_rubrica) {
		this.desc_rubrica = desc_rubrica;
	}

	public List<Recurso> getRecursos() {
		return recursos;
	}

	public void setRecursos(List<Recurso> recursos) {
		this.recursos = recursos;
	}
	

}
