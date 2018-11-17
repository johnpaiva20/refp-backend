package com.tostringtech.refp.core.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class RecursoProjetoId implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Column(name = "cod_projeto")
	private Long codProjeto;
	@Column(name = "cod_recurso")
	private Long codRecurso;
	
	
	public RecursoProjetoId() {}
	
	public RecursoProjetoId(Long codProjeto, Long codRecurso) {
		this.codProjeto = codProjeto;
		this.codRecurso = codRecurso;
	}
	public Long getCodProjeto() {
		return codProjeto;
	}
	public void setCodProjeto(Long codProjeto) {
		this.codProjeto = codProjeto;
	}
	public Long getCodRecurso() {
		return codRecurso;
	}
	public void setCodRecurso(Long codRecurso) {
		this.codRecurso = codRecurso;
	}

	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codProjeto == null) ? 0 : codProjeto.hashCode());
		result = prime * result + ((codRecurso == null) ? 0 : codRecurso.hashCode());
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
		RecursoProjetoId other = (RecursoProjetoId) obj;
		if (codProjeto == null) {
			if (other.codProjeto != null)
				return false;
		} else if (!codProjeto.equals(other.codProjeto))
			return false;
		if (codRecurso == null) {
			if (other.codRecurso != null)
				return false;
		} else if (!codRecurso.equals(other.codRecurso))
			return false;
		return true;
	}
	
	
	
	
}
