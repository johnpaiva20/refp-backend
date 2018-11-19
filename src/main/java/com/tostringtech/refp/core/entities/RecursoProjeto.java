package com.tostringtech.refp.core.entities;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

import io.swagger.annotations.ApiModelProperty;

@Entity(name = "RecursosProjeto")
@Table(name = "Recursos_Projeto")
public class RecursoProjeto {

	
	@EmbeddedId
	@ApiModelProperty(hidden = true)
	private RecursoProjetoId codRecursosProjeto;
	
	@ManyToOne(fetch= FetchType.LAZY)
	@MapsId("codProjeto")
	private Projeto projeto;
	
	@ManyToOne(fetch= FetchType.LAZY)
	@MapsId("codRecurso")
	private Recurso recurso;
	
	@Column(name = "valor_recurso")
	private Double valorRecurso;

	public RecursoProjeto() {}
	
	public RecursoProjeto(RecursoProjetoId codRecursosProjeto, Projeto projeto, Recurso recurso, Double valorRecurso) {
		this.codRecursosProjeto = codRecursosProjeto;
		this.projeto = projeto;
		this.recurso = recurso;
		this.valorRecurso = valorRecurso;
	}
	
	public RecursoProjetoId getCodRecursosProjeto() {
		return codRecursosProjeto;
	}

	public void setCodRecursosProjeto(RecursoProjetoId codRecursosProjeto) {
		this.codRecursosProjeto = codRecursosProjeto;
	}

	public Projeto getProjeto() {
		return projeto;
	}

	public void setProjeto(Projeto projeto) {
		this.projeto = projeto;
	}

	public Recurso getRecurso() {
		return recurso;
	}

	public void setRecurso(Recurso recurso) {
		this.recurso = recurso;
	}

	public Double getValorRecurso() {
		return valorRecurso;
	}

	public void setValorRecurso(Double valorRecurso) {
		this.valorRecurso = valorRecurso;
	}
	
	
	
	
}
