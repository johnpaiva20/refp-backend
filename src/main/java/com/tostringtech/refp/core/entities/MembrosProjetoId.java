package com.tostringtech.refp.core.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class MembrosProjetoId implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name = "cod_projeto")
	private Long codProjeto;
	@Column(name = "cod_membro")
	private Long codMembro;
	
	

	public MembrosProjetoId() {
	}

	public MembrosProjetoId(Long codProjeto, Long codMembro) {
		this.codProjeto = codProjeto;
		this.codMembro = codMembro;
	}

	public Long getCodProjeto() {
		return codProjeto;
	}

	public void setCodProjeto(Long codProjeto) {
		this.codProjeto = codProjeto;
	}

	public Long getCodMembro() {
		return codMembro;
	}

	public void setCodMembro(Long codMembro) {
		this.codMembro = codMembro;
	}

}
