package com.tostringtech.refp.core.entities;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

@Entity(name = "RecursosProjeto")
@Table(name = "Recursos_Projeto")
public class RecursosProjeto {

	
	@EmbeddedId
	private RecursosProjetoId codRecursosProjeto;
	
	@ManyToOne(fetch= FetchType.LAZY)
	@MapsId("codProjeto")
	private Projeto projeto;
	
	@ManyToOne(fetch= FetchType.LAZY)
	@MapsId("codRecurso")
	private Recurso recurso;
	
	@Column(name = "valor_recurso")
	private Long valorRecurso;

	public RecursosProjeto() {}
	
	public RecursosProjeto(RecursosProjetoId codRecursosProjeto, Projeto projeto, Recurso recurso, Long valorRecurso) {
		this.codRecursosProjeto = codRecursosProjeto;
		this.projeto = projeto;
		this.recurso = recurso;
		this.valorRecurso = valorRecurso;
	}
	
	public RecursosProjetoId getCodRecursosProjeto() {
		return codRecursosProjeto;
	}

	public void setCodRecursosProjeto(RecursosProjetoId codRecursosProjeto) {
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

	public Long getValorRecurso() {
		return valorRecurso;
	}

	public void setValorRecurso(Long valorRecurso) {
		this.valorRecurso = valorRecurso;
	}
	
	
	
}
