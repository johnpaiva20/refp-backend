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
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Rubrica implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String codRubrica;

	@Column
	private String descRubrica;

	@ManyToOne(targetEntity = TipoProjeto.class)
	@JoinColumn(name = "tpProjeto")
	private TipoProjeto tpProjeto;

	@OneToMany
	@JsonIgnore
	@JoinTable(name = "recursos_rubrica", joinColumns = @JoinColumn(name = "codRubrica"), inverseJoinColumns = @JoinColumn(name = "codRecurso"))
	private List<Recurso> recursos = new ArrayList<>();

	public Rubrica() {
	}

	public Rubrica(String codRubrica, String descRubrica) {
		this.codRubrica = codRubrica;
		this.descRubrica = descRubrica;
	}

	public String getCod_rubrica() {
		return codRubrica;
	}

	public void setCod_rubrica(String cod_rubrica) {
		this.codRubrica = cod_rubrica;
	}

	public String getDesc_rubrica() {
		return descRubrica;
	}

	public void setDesc_rubrica(String desc_rubrica) {
		this.descRubrica = desc_rubrica;
	}

	public List<Recurso> getRecursos() {
		return recursos;
	}

	public void setRecursos(List<Recurso> recursos) {
		this.recursos = recursos;
	}

}
